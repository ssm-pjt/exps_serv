package exps.api.sample.packet;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 샘플 객체
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Tag(name="파일 업로드 요청 객체")
public class ReqFileDataSample {
    @Schema(title =  "데이터")
    private String data;
    @Schema(title =  "업로드 단건파일")
    private MultipartFile file;
}
