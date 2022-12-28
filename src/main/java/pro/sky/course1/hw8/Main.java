package pro.sky.course1.hw8;

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
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        flipFullName(reverseFullName);
        System.out.println("--");

        /* Если попроще:
        System.out.printf("Сумма трат за месяц составила %d рублей\n", Arrays.stream(ledger).sum());
        System.out.printf("Минимальная сумма трат за день составила %d рублей. Максимальная сумма трат за день составила %d рублей\n",
                Arrays.stream(ledger).min().getAsInt(), Arrays.stream(ledger).max().getAsInt());
        System.out.printf("Средняя сумма трат за месяц составила %f рублей\n", Arrays.stream(ledger).average().getAsDouble());
         */

        // Task 5
        System.out.println("Task 5");
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == j) || (i + j == 2)) {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println("--");

        // Task 6
        System.out.println("Task 6");
        int[] array = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(flipIntArray(array)));
        System.out.println("--");

        // Task 7
        System.out.println("Task 7");
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(flipIntArrayWithoutSecondArray(array)));
        System.out.println("--");

        // Task 8
        System.out.println("Task 8");
        int[] array1 = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        int neededSum = -2;
        findPairInArrayThatGivesNumberInTotal(array1, neededSum);
        System.out.println("--");

        // Task 9
        System.out.println("Task 9");
        findAllPairsInArrayThatGivesNumberInTotal(array1, neededSum);
        System.out.println("--");
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
        for (int i = reverseFullName.length - 1; i >= 0; i--) {
            System.out.print(reverseFullName[i]);
        }
        System.out.println();
    }

    public static int getSum(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    public static double getAverage(int[] array) {
        return array.length == 0 ? 0 : (double) getSum(array) / array.length;
    }

    public static int getMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int number : array) {
            if (min > number) {
                min = number;
            }
        }
        return min;
    }

    public static int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int number : array) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public static int[] flipIntArray(int[] array) {
        int[] rightVersionOfArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            rightVersionOfArray[i] = array[array.length - i - 1];
        }
        return rightVersionOfArray;
    }

    public static int[] flipIntArrayWithoutSecondArray(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < (array.length + 1) / 2 - 1; i++) {
            int temp = result[i];
            result[i] = result[array.length - i - 1];
            result[array.length - i - 1] = temp;
        }
        return result;
    }

    public static void findPairInArrayThatGivesNumberInTotal(int[] array, int neededSum) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        boolean isFound = false;
        while ((leftPointer != rightPointer) && !isFound) {
            int temp = array[leftPointer] + array[rightPointer];
            if (temp == neededSum) {
                System.out.printf("%d and %d\n", array[leftPointer], array[rightPointer]);
                isFound = true;
            } else if (temp < neededSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        if (!isFound) {
            System.out.printf("There is no pair of integers in this array, that give %d in total\n", neededSum);
        }
    }

    public static void findAllPairsInArrayThatGivesNumberInTotal(int[] array, int neededSum) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        boolean isFound = false;
        while (leftPointer != rightPointer) {
            int temp = array[leftPointer] + array[rightPointer];
            if (temp == neededSum) {
                System.out.printf("%d and %d\n", array[leftPointer], array[rightPointer]);
                isFound = true;
                leftPointer++;
            } else if (temp < neededSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        if (!isFound) {
            System.out.printf("There is no pair of integers in this array, that give %d in total\n", neededSum);
        }
    }
}
