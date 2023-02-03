package exps.exception.file;

/**
 *  
 * 파일 유효성 체크 실패
 */
public class FileNotContractIdException extends RuntimeException {

    private static final long serialVersionUID = -5477511417727878892L;

    public FileNotContractIdException() {
        super();
    }

    public FileNotContractIdException(String message) {
        super(message);
    }
}
