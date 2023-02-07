package pro.sky.course3.coursework.model.enums;

public enum OperationType {
    RECEIVING("receiving"),
    RELEASE("release"),
    WRITE_OFF("write_off");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
