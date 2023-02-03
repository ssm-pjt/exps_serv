package exps.exception.common;

/**
 *  
 * 필수 파라메터 누락
 */
public class RequestParamRequiredException extends RuntimeException {

    private static final long serialVersionUID = 6962266920502063253L;

    public RequestParamRequiredException() {
    }

    public RequestParamRequiredException(String message) {
        super(message);
    }

    public RequestParamRequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestParamRequiredException(Throwable cause) {
        super(cause);
    }

    public RequestParamRequiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
