package exps.exception.common;

/**
 * AES 복호화 에러 예외처리
 *  
 */
public class AesDecryptException extends RuntimeException {

    private static final long serialVersionUID = -1391803130428006592L;

    public AesDecryptException() {
    }

    public AesDecryptException(String message) {
        super(message);
    }

    public AesDecryptException(String message, Throwable cause) {
        super(message, cause);
    }

    public AesDecryptException(Throwable cause) {
        super(cause);
    }

    public AesDecryptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
