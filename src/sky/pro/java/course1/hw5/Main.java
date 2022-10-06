package sky.pro.java.course1.hw5;

public class Main {
    public static void main(String[] args) {
        task1_1();
        task1_2();
        task1_3();
        task1_4();
        task2_1();
        task2_2();
        task2_3();
        task3_1();
        task3_2();
    }

    // Task 1.1
    public static void task1_1() {
        System.out.println("Task 1.1");
        for (int i = 0; i < 10; i++)
            System.out.printf("%d ", i + 1);
        System.out.print("\n--\n");
    }

    // Task 1.2
    public static void task1_2() {
        System.out.println("Task 1.2");
        for (int i = 10; i > 0; i--)
            System.out.printf("%d ", i);
        System.out.print("\n--\n");
    }

    // Task 1.3
    public static void task1_3() {
        System.out.println("Task 1.3");
        for (int i = 0; i < 9; i++)
            System.out.printf("%d ", 2 * i);
        System.out.print("\n--\n");
    }

    // Task 1.4
    public static void task1_4() {
        System.out.println("Task 1.4");
        for (int i = 10; i >= -10; i--)
            System.out.printf("%d ", i);
        System.out.print("\n--\n");
    }

    // Task 2.1
    public static void task2_1() {
        System.out.println("Task 2.1");
        for (int i = 1904; i <= 2096; i += 4)
            System.out.printf("%d ", i);
        System.out.print("\n--\n");
    }

    // Task 2.2
    public static void task2_2() {
        System.out.println("Task 2.2");
        for (int i = 7; i <= 98; i++)
            System.out.printf("%d ", i);
        System.out.print("\n--\n");
    }

    // Task 2.3
    public static void task2_3() {
        System.out.println("Task 2.3");
        for (int i = 0; i < 10; i++)
            System.out.printf("%.0f ", Math.pow(2, i));
        System.out.print("\n--\n");
    }

    // Task 3.1
    public static void task3_1() {
        System.out.println("Task 3.1");
        double contribution = 29000;
        double amountOfSavings = 0;
        for (int i = 1; i <= 12; i++) {
            amountOfSavings += contribution;
            System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", i, amountOfSavings);
        }
        System.out.print("--\n");
    }

    // Task 3.2
    public static void task3_2() {
        System.out.println("Task 3.2");
        double contribution = 29000;
        double amountOfSavings = 0;
        for (int i = 1; i <= 12; i++) {
            amountOfSavings = 1.01 * amountOfSavings + contribution; // положил деньги в конце месяца - процентов за внесенную часть не начисляется
            System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", i, amountOfSavings);
        }
        System.out.print("--\n");
    }
}
