package sky.pro.java.course1.exam_1;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = new String[] {"a", "a", "b", "a", "a", "b", "a",
                "a", "b", "a", "c", "b", "a", "b", "c", "d", "b", "a", "c", "d"};
        System.out.println(deleteDuplicatesAndUniteToOneString(stringArray));
    }

    public static String deleteDuplicatesAndUniteToOneString(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null) {
                for (int j = i + 1; j < stringArray.length; j++) {
                    if (stringArray[i].equals(stringArray[j])) {
                        stringArray[j] = null;
                    }
                }
                stringBuilder.append(stringArray[i]);
            }
        }
        return stringBuilder.toString();
    }
}
