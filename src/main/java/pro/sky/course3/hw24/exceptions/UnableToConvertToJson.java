package pro.sky.course3.hw24.exceptions;

public class UnableToConvertToJson extends RuntimeException {
    public UnableToConvertToJson() {
    }

    public UnableToConvertToJson(String message) {
        super(message);
    }

    public UnableToConvertToJson(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToConvertToJson(Throwable cause) {
        super(cause);
    }
}
