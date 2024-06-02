package WeeklyAssignment2.Exceptions;

/**
 * The {@code UserNotFoundException} throwable when an invalid account/user is accessed
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found. Check your account number.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getErrorCode() {
        return 404;
    }
}
