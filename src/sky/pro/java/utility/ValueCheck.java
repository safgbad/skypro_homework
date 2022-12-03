package sky.pro.java.utility;

public class ValueCheck {
    public static boolean isStringNotNullAndNotBlank(String str) {
        return str != null && !str.isBlank();
    }

    public static <T extends Number> boolean isNumberNotNullAndNotNegative (T num) {
        return num != null && num.doubleValue() >= 0;
    }
}
