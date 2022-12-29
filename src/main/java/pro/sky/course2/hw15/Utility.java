package pro.sky.course2.hw15;

public class Utility {
    public static final String DELIMITER = "----------";

    public static boolean isStringNotNullOrBlank(String str) {
        return !(str == null || str.isBlank());
    }

    public static boolean isNumberNotNullOrNegative(Integer number) {
        return !(number == null || number < 0);
    }

    public static boolean isNumberNotNullOrNegative(Double number) {
        return !(number == null || number < 0);
    }
}
