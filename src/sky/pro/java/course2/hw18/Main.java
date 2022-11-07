package sky.pro.java.course2.hw18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printOddNumbers(nums);

        // Task 2
        printEvenNumbersWithoutDuplicatesAscending(nums);

        // Task 3
        List<String> words = Arrays.asList("a", "a", "b", "a", "a", "b", "a",
                "a", "b", "a", "c", "b", "a", "b", "c", "d", "b", "a", "c", "d");
        printWordsWithoutDuplicates(words);

        // Task 4
        printNumberOfDuplicates(words);
    }

    public static void printOddNumbers(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 == 1) {
                System.out.printf("%d ", num);
            }
        }
        System.out.println();
    }

    public static void printEvenNumbersWithoutDuplicatesAscending(List<Integer> nums) {
        ExcludeDuplicates<Integer> numsToPrint = new ExcludeDuplicates<>(nums);
        numsToPrint.LIST.sort(Comparator.naturalOrder());
        for (Integer num : numsToPrint.LIST) {
            if (num % 2 == 0) {
                System.out.printf("%d ", num);
            }
        }
        System.out.println();
    }

    public static void printWordsWithoutDuplicates(List<String> words) {
        ExcludeDuplicates<String> wordsToPrint = new ExcludeDuplicates<>(words);
        for (String word : wordsToPrint.LIST) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }

    public static void printNumberOfDuplicates(List<String> words) {
        ExcludeDuplicates<String> wordsToPrint = new ExcludeDuplicates<>(words);
        for (Map.Entry<String, Integer> entry : wordsToPrint.MAP.entrySet()) {
            System.out.printf("\"%s\": %d times; ", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static class ExcludeDuplicates <T> {
        private final Map<T, Integer> MAP;
        private final List<T> LIST;

        public ExcludeDuplicates(List<T> originalList) {
            MAP = new HashMap<>();
            for (T element : originalList) {
                if (!MAP.containsKey(element)) {
                    MAP.put(element, 1);
                } else {
                    MAP.put(element, MAP.get(element) + 1);
                }
            }
            LIST = new ArrayList<>(MAP.keySet());
        }
    }
}
