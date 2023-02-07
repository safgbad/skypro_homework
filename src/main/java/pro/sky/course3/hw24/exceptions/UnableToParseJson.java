package pro.sky.course3.hw24.exceptions;

public class UnableToParseJson extends Exception {

    public UnableToParseJson() {
    }

    public UnableToParseJson(String message) {
        super(message);
    }

    public UnableToParseJson(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToParseJson(Throwable cause) {
        super(cause);
    }
}
