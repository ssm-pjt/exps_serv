package exps.utils.common;

import java.io.IOException;
import java.util.Map;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JWT 를 통한 인증 토큰
 * 토큰은 앱과 서버가 통신 및 인증할때 가장 많이 사용
 * 토큰 기반 인증 시스템은 클라이언트가 서버에 접속을 하면 서버에서 해당 클라이언트에게 인증되었다는 의미로 '토큰'을 부여한다
 * 인증 유틸
 */
public class AuthUtils {

    /**
     * JWT 복호화
     * @param data
     * @param secretKey
     * @return
     * @throws IOException
     */
    public static Map<String, String> jwtDecoder(String data, String secretKey) {

        ObjectMapper mapper = new ObjectMapper();

        SignatureVerifier verifier = new MacSigner(secretKey);
        Jwt jwt = JwtHelper.decodeAndVerify(data, verifier);
        Map resultMap = null;
        try {
            resultMap = mapper.readValue(jwt.getClaims(), Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
        return resultMap;

    }

    /**
     * userId 셋팅
     * @param jwt
     * @param secretKey
     * @return
     * @throws IOException
     */
    public static String getUserId(String jwt, String secretKey) {
        String userId = "";
        if(jwt != null)
            userId = jwtDecoder(jwt, secretKey).get("id");

        return userId;
    }

}
