package pro.sky.course3.coursework.exceptions;

public class NothingToImportException extends Exception {
    public NothingToImportException() {
    }

    public NothingToImportException(String message) {
        super(message);
    }

    public NothingToImportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NothingToImportException(Throwable cause) {
        super(cause);
    }
}
