package sky.pro.java.course1.hw7;

import java.util.ArrayList;
import java.util.Arrays;

class crossMethodStruct {
    public int[] integerArray;
    public double[] doubleArray;
    public ArrayList<String>[] arrayOfArrayLists;

    public crossMethodStruct(int[] integerArray, double[] doubleArray, ArrayList<String>[] arrayOfArrayLists) {
        this.integerArray = integerArray;
        this.doubleArray = doubleArray;
        this.arrayOfArrayLists = arrayOfArrayLists;
    }
}

public class Main {
    public static void main(String[] args) {
        // Task 1
        int[] integerArray = new int[3];
        integerArray[0] = 1;
        integerArray[1] = 2;
        integerArray[2] = 3;
        double[] doubleArray = {1.57, 7.654, 9.986};
        String[] stringArray = new String[] {"a o a", "synchrophasotron", "RAID Shadow Legends"};

        // Task 2
        int integerArray_length = integerArray.length;
        for (int i = 0; i < integerArray_length - 1; i++)
            System.out.printf("%d, ", integerArray[i]);
        System.out.printf("%d\n", integerArray[integerArray_length - 1]);
        int doubleArray_length = doubleArray.length;
        for (int i = 0; i < doubleArray_length - 1; i++)
            System.out.printf("%f, ", doubleArray[i]);
        System.out.printf("%f\n", doubleArray[doubleArray_length - 1]);
        int stringArray_length = stringArray.length;
        for (int i = 0; i < stringArray_length - 1; i++)
            System.out.printf("%s, ", stringArray[i]);
        System.out.printf("%s\n", stringArray[stringArray_length - 1]);
        System.out.println("--");

        // Task 3
        for (int i = integerArray_length - 1; i > 0; i--)
            System.out.printf("%d, ", integerArray[i]);
        System.out.printf("%d\n", integerArray[0]);
        for (int i = doubleArray_length - 1; i > 0; i--)
            System.out.printf("%f, ", doubleArray[i]);
        System.out.printf("%f\n", doubleArray[0]);
        for (int i = stringArray_length - 1; i > 0; i--)
            System.out.printf("%s, ", stringArray[i]);
        System.out.printf("%s\n", stringArray[0]);
        System.out.println("--");

        // Task 4
        System.out.println("Task 4");
        for (int i = 0; i < integerArray_length; i++) {
            if (integerArray[i] % 2 == 1)
                integerArray[i]++;
        }
        for (int i = 0; i < integerArray_length - 1; i++)
            System.out.printf("%d, ", integerArray[i]);
        System.out.printf("%d\n", integerArray[integerArray_length - 1]);

        /* В принципе это не имеет значения... Там то же самое +-, но с массивом ArrayList'ов
        task2(task1(args));
        task3(task1(args));
        task4(task1(args));
         */
    }

    // Task 1
    public static crossMethodStruct task1(String[] args) {
        int[] integerArray = new int[3];
        integerArray[0] = 1;
        integerArray[1] = 2;
        integerArray[2] = 3;
        double[] doubleArray = {1.57, 7.654, 9.986};
        String crimeAndPunishment = "On an exceptionally hot evening early in July a young man came out of the garret in which he lodged in S. Place and walked slowly as though in hesitation towards K. bridge";
        ArrayList<String>[] arrayOfArrayLists = new ArrayList[]{new ArrayList<>(Arrays.asList("London", "is", "the", "capital", "of", "Great", "Britain")),
                new ArrayList<>(Arrays.asList((crimeAndPunishment.split(" ")))),
                new ArrayList<>(Arrays.asList(args))};
        return new crossMethodStruct(integerArray, doubleArray, arrayOfArrayLists);
    }

    // Task 2
    public static void task2(crossMethodStruct struct) {
        System.out.println("Task 2");
        for (int i = 0; i < struct.integerArray.length - 1; i++)
            System.out.printf("%d, ", struct.integerArray[i]);
        System.out.printf("%d\n", struct.integerArray[struct.integerArray.length - 1]);
        for (int i = 0; i < struct.doubleArray.length - 1; i++)
            System.out.printf("%f, ", struct.doubleArray[i]);
        System.out.printf("%f\n", struct.doubleArray[struct.doubleArray.length - 1]);
        for (int i = 0; i < struct.arrayOfArrayLists.length - 1; i++)
            System.out.printf("%s, ", struct.arrayOfArrayLists[i]);
        System.out.printf("%s\n", struct.arrayOfArrayLists[struct.arrayOfArrayLists.length - 1]);
        System.out.println("--");
    }

    // Task 3
    public static void task3(crossMethodStruct struct) {
        System.out.println("Task 3");
        for (int i = struct.integerArray.length - 1; i > 0; i--)
            System.out.printf("%d, ", struct.integerArray[i]);
        System.out.printf("%d\n", struct.integerArray[0]);
        for (int i = struct.doubleArray.length - 1; i > 0; i--)
            System.out.printf("%f, ", struct.doubleArray[i]);
        System.out.printf("%f\n", struct.doubleArray[0]);
        for (int i = struct.arrayOfArrayLists.length - 1; i > 0; i--)
            System.out.printf("%s, ", struct.arrayOfArrayLists[i]);
        System.out.printf("%s\n", struct.arrayOfArrayLists[0]);
        System.out.println("--");
    }

    // Task 4
    public static void task4(crossMethodStruct struct) {
        System.out.println("Task 4");
        for (int i = 0; i < struct.integerArray.length; i++) {
            if (struct.integerArray[i] % 2 == 1)
                struct.integerArray[i]++;
        }
        for (int i = 0; i < struct.integerArray.length - 1; i++)
            System.out.printf("%d, ", struct.integerArray[i]);
        System.out.printf("%d\n", struct.integerArray[struct.integerArray.length - 1]);
        System.out.println("--");
    }
}