package by.tms.exception;

public class IsNotFoundException extends RuntimeException{
    public IsNotFoundException() {
        super();
    }

    public IsNotFoundException(String message) {
        super(message);
    }

    public IsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected IsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
