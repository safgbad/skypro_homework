package pro.sky.course3.coursework.exceptions;

public class NotEnoughSocksException extends Exception {
    public NotEnoughSocksException() {
    }

    public NotEnoughSocksException(String message) {
        super(message);
    }

    public NotEnoughSocksException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughSocksException(Throwable cause) {
        super(cause);
    }
}
