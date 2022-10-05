package sky.pro.java.course1.hw8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ledger = generateRandomArray();
        // Task 1
        System.out.println("Task 1");
        System.out.printf("Сумма трат за месяц составила %d рублей\n", getSum(ledger));
        System.out.println("--");

        // Task 2
        System.out.println("Task 2");
        System.out.printf("Минимальная сумма трат за день составила %d рублей. Максимальная сумма трат за день составила %d рублей\n",
                getMin(ledger), getMax(ledger));
        System.out.println("--");

        // Task 3
        System.out.println("Task 3");
        System.out.printf("Средняя сумма трат за месяц составила %f рублей\n", getAverage(ledger));
        System.out.println("--");

        // Task 4
        System.out.println("Task 4");
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        flipFullName(reverseFullName);

        /* Если попроще:
        System.out.printf("Сумма трат за месяц составила %d рублей\n", Arrays.stream(ledger).sum());
        System.out.printf("Минимальная сумма трат за день составила %d рублей. Максимальная сумма трат за день составила %d рублей\n",
                Arrays.stream(ledger).min().getAsInt(), Arrays.stream(ledger).max().getAsInt());
        System.out.printf("Средняя сумма трат за месяц составила %f рублей\n", Arrays.stream(ledger).average().getAsDouble());
         */
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static void flipFullName(char[] reverseFullName) {
        for (int i = reverseFullName.length - 1; i >= 0; i--)
            System.out.print(reverseFullName[i]);
        System.out.println();
    }

    public static int getSum(int[] array) {
        int sum = 0;
        for (int number : array)
            sum += number;
        return sum;
    }

    public static double getAverage(int[] array) {
        return array.length == 0 ? 0 : (double) getSum(array) / array.length;
    }

    public static int getMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int number : array) {
            if (min > number)
                min = number;
        }
        return min;
    }

    public static int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int number : array) {
            if (max < number)
                max = number;
        }
        return max;
    }
}
