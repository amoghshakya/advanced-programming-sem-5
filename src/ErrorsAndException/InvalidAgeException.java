package ErrorsAndException;

public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super("Age must be greater than 21.");
    }

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAgeException(Throwable cause) {
        super(cause);
    }

    public InvalidAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
