package sky.pro.java.course2.hw16.utility;

public class InputCheck {
    public static boolean isStringNotNullAndNotBlank(String str) {
        return str != null && !str.isBlank();
    }

    public static boolean isNumberNotNullAndNotNegative(Double num) {
        return num != null && num >= 0;
    }

    public static boolean isNumberNotNullAndNotNegative(Integer num) {
        return num != null && num >= 0;
    }
}
