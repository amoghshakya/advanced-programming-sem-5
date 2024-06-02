package WeeklyAssignment2.Exceptions;

public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException() {
        super("Invalid account number. Account numbers can only include numeric values. Check again.");
    }

    public InvalidAccountNumberException(String message) {
        super(message);
    }

    public InvalidAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAccountNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidAccountNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
