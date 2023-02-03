package exps.exception.file;

/**
 *  
 * 파일 중복 체크
 */
public class FileDuplicateException extends RuntimeException {

    private static final long serialVersionUID = 6958449475647886122L;

    public FileDuplicateException() {
        super();
    }

    public FileDuplicateException(String message) {
        super(message);
    }
}
