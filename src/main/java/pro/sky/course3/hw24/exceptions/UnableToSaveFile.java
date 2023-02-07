package pro.sky.course3.hw24.exceptions;

public class UnableToSaveFile extends RuntimeException {
    public UnableToSaveFile() {
    }

    public UnableToSaveFile(String message) {
        super(message);
    }

    public UnableToSaveFile(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToSaveFile(Throwable cause) {
        super(cause);
    }
}
