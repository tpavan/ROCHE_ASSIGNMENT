package exception;

public class SuiteException extends Exception {
    public SuiteException() {
    }

    public SuiteException(String message) {
        super(message);
    }

    public SuiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuiteException(Throwable cause) {
        super(cause);
    }
}
