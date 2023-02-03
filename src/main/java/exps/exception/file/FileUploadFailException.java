package exps.exception.file;

/**
 * 파일업로드 실패 예외처리
 *  
 */
public class FileUploadFailException extends RuntimeException {

    private static final long serialVersionUID = 1688880015002090307L;

    public FileUploadFailException() {
        super();
    }

    public FileUploadFailException(String message) {
        super(message);
    }

    public FileUploadFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadFailException(Throwable cause) {
        super(cause);
    }

    protected FileUploadFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
