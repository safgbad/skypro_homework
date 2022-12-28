package pro.sky.course2.hw13;

public class Utility {
    public static final Long SECONDS_IN_MINUTE = 60L;
    public static final Long MINUTES_IN_HOUR = 60L;
    public static final Long HOURS_IN_DAY = 24L;
    public static final Long SECONDS_IN_HOUR = SECONDS_IN_MINUTE * MINUTES_IN_HOUR;
    public static final Long SECONDS_IN_DAY = SECONDS_IN_HOUR * HOURS_IN_DAY;
    public static final String EMPTY_STRING = "";

    public static boolean isStringNotNullOrBlank(String str) {
        return !(str == null || str.isBlank());
    }

    public static boolean isNumberNotNullOrNegative(Integer number) {
        return !(number == null || number < 0);
    }

    public static boolean isNumberNotNullOrNegative(Double number) {
        return !(number == null || number < 0);
    }

    public static boolean isNumberNotNullOrNegative(Long number) {
        return !(number == null || number < 0);
    }

    public static String getTimeWithDays(Long seconds) {
        Long remainder = seconds % SECONDS_IN_DAY;
        String remainderString = getTimeWithHours(remainder);
        long division = seconds / SECONDS_IN_DAY;
        if (division > 0) {
            return String.format("%d дней%s", division,
                    isStringNotNullOrBlank(remainderString) ? ", " + remainderString : EMPTY_STRING);
        }
        return remainderString;
    }

    public static String getTimeWithHours(Long seconds) {
        Long remainder = seconds % SECONDS_IN_HOUR;
        String remainderString = getTimeWithMinutes(remainder);
        long division = seconds / SECONDS_IN_HOUR;
        if (division > 0) {
            return String.format("%d часов%s", division,
                    isStringNotNullOrBlank(remainderString) ? ", " + remainderString : EMPTY_STRING);
        }
        return remainderString;
    }

    public static String getTimeWithMinutes(Long seconds) {
        Long remainder = seconds % SECONDS_IN_MINUTE;
        String remainderString = getTimeWithSeconds(remainder);
        long division = seconds / SECONDS_IN_MINUTE;
        if (division > 0) {
            return String.format("%d минут%s", division,
                    isStringNotNullOrBlank(remainderString) ? ", " + remainderString : EMPTY_STRING);
        }
        return remainderString;
    }

    public static String getTimeWithSeconds(Long seconds) {
        if (seconds > 0) {
            return String.format("%d секунд", seconds);
        } else {
            return EMPTY_STRING;
        }
    }

    public static void printObjects(Object[] objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
