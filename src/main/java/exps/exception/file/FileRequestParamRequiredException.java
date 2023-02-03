package exps.exception.file;

/**
 *  
 */
public class FileRequestParamRequiredException extends RuntimeException {

    private static final long serialVersionUID = 5466524715629238130L;

    public FileRequestParamRequiredException() {
        super();
    }

    public FileRequestParamRequiredException(String message) {
        super(message);
    }
}
