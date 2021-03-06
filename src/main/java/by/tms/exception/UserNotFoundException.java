package by.tms.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
    }

    public UserNotFoundException(String message){
    super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
