package pro.sky.course3.coursework.exceptions;

public class NothingToExportException extends Exception {
    public NothingToExportException() {
    }

    public NothingToExportException(String message) {
        super(message);
    }

    public NothingToExportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NothingToExportException(Throwable cause) {
        super(cause);
    }
}
