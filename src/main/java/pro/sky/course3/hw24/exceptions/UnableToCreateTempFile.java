package pro.sky.course3.hw24.exceptions;

public class UnableToCreateTempFile extends Exception {
    public UnableToCreateTempFile() {
    }

    public UnableToCreateTempFile(String message) {
        super(message);
    }

    public UnableToCreateTempFile(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToCreateTempFile(Throwable cause) {
        super(cause);
    }
}
