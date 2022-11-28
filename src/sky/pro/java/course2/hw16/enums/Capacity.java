package sky.pro.java.course2.hw16.enums;

public enum Capacity {
    XS(null, 10),
    S(10, 25),
    M(25, 50),
    L(50, 80),
    XL(80, 120);

    private final Integer lowerLimit;
    private final Integer upperLimit;

    Capacity(Integer lowerLimit, Integer upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public static Capacity getRandom() {
        Capacity[] values = Capacity.values();
        int index = (int) (values.length * Math.random());
        return values[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Вместимость:");
        if (lowerLimit != null) {
            stringBuilder.append(" от ").append(lowerLimit);
        }
        if (upperLimit != null) {
            stringBuilder.append(" до ").append(upperLimit);
        }
        stringBuilder.append(" человек");
        return stringBuilder.toString();
    }
}
