package pro.sky.course2.exam2;

public class TooManyBooksException extends RuntimeException {
    public TooManyBooksException() {}

    public TooManyBooksException(String message) {
        super(message);
    }

    public TooManyBooksException(Throwable cause) {
        super(cause);
    }

    public TooManyBooksException(String message, Throwable cause) {
        super(message, cause);
    }
}
