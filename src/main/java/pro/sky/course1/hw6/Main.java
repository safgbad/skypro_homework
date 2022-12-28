package pro.sky.course1.hw6;

public class Main {
    public static void main(String[] args) {
        task1_1(29000, 12);
        task1_2();
        task1_3();
        double ratePerMonth = 7;
        double contribution = 15000;
        task2_1(ratePerMonth, contribution);
        task2_2(ratePerMonth, contribution);
        int numberOfYears = 9;
        task2_3(ratePerMonth, contribution, numberOfYears);
        int firstFriday = 4;
        task2_4(firstFriday);
        task3_1();
        task3_2();
        task4_1();
        task4_2();
    }

    // Task 1.1
    public static void task1_1(double contribution, double rate) {
        System.out.println("Task 1.1");
        double amountOfSavings = 0;
        double multiplier = 1 + rate / 12 / 100;
        int numberOfMonths = 0;
        while (amountOfSavings < 2459000) {
            amountOfSavings = multiplier * (amountOfSavings + contribution);
            numberOfMonths++;
        }
        System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n--\n", numberOfMonths, amountOfSavings);
    }

    // Task 1.2
    public static void task1_2() {
        System.out.println("Task 1.2");
        int n = 0;
        while (n < 10)
            System.out.printf("%d ", ++n);
        System.out.println();
        for (int i = n; i > 0; i--) {
            System.out.printf("%d ", i);
        }
        System.out.println("\n--");
    }

    // Task 1.3
    public static void task1_3() {
        System.out.println("Task 1.3");
        int population = 12000000;
        int birthRatePer1000 = 17;
        int deathRatePer1000 = 8;
        for (int i = 0; i < 10; i++) {
            double resultOfDivision = (double) population / 1000;
            population = population + (int) (resultOfDivision * birthRatePer1000) - (int) (resultOfDivision * deathRatePer1000);
            System.out.printf("Год %d, численность населения составляет %d\n", i + 1, population);
        }
        System.out.println("--");
    }

    // Task 2.1
    public static void task2_1(double ratePerMonth, double contribution) {
        System.out.println("Task 2.1");
        double amountOfSavings = contribution;
        double multiplier = 1 + ratePerMonth / 100;
        int numberOfMonths = 0;
        while (amountOfSavings < 12000000) {
            amountOfSavings *= multiplier;
            System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", ++numberOfMonths, amountOfSavings);
        }
        System.out.printf("Итого: %d месяцев\n", numberOfMonths);
        System.out.println("--");
    }

    // Task 2.2
    public static void task2_2(double ratePerMonth, double contribution) {
        System.out.println("Task 2.2");
        double amountOfSavings = contribution;
        double multiplier = 1 + ratePerMonth / 100;
        int numberOfMonths = 0;
        while (amountOfSavings < 12000000) {
            amountOfSavings *= multiplier;
            if (++numberOfMonths % 6 == 0)
                System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", numberOfMonths, amountOfSavings);
        }
        System.out.printf("Итого: %d месяцев\n", numberOfMonths);
        System.out.println("--");
    }

    // Task 2.3
    public static void task2_3(double ratePerMonth, double contribution, int numberOfYears) {
        System.out.println("Task 2.3");
        double amountOfSavings = contribution;
        double multiplier = 1 + ratePerMonth / 100;
        int numberOfMonths = 0;
        while (numberOfMonths < numberOfYears * 12) {
            amountOfSavings *= multiplier;
            if (++numberOfMonths % 6 == 0)
                System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", numberOfMonths, amountOfSavings);
        }
        System.out.println("--");
    }

    // Task 2.4
    public static void task2_4(int firstFriday) {
        System.out.println("Task 2.4");
        int currentFriday = firstFriday;
        while (currentFriday <= 31) {
            System.out.printf("Сегодня пятница, %d-е число. Необходимо подготовить отчет.\n", currentFriday);
            currentFriday += 7;
        }
        System.out.println("--");
    }

    // Task 3.1
    public static void task3_1() {
        System.out.println("Task 3.1");
        int year = 0;
        int currentYear = 2022;
        int period = 79;
        while (year <= currentYear) {
            if (year > (currentYear - 200))
                System.out.println(year);
            year += period;
        }
        System.out.println(year);
        System.out.println("--");
    }

    // Task 3.2
    public static void task3_2() {
        System.out.println("Task 3.2");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("2*%d=%d\n", i, 2 * i);
        }
        System.out.println("--");
    }

    // Task 4.1
    public static void task4_1() {
        System.out.println("Task 4.1");
        for (int i = 1; i <= 30; i++) {
            System.out.printf("%d. ", i);
            if (i % 3 == 0)
                System.out.print("ping ");
            if (i % 5 == 0)
                System.out.print("pong");
            System.out.println();
        }
        System.out.println("--");
    }

    // Task 4.2
    public static void task4_2() {
        System.out.println("Task 4.2");
        int prevPrev = 0;
        int prev = 1;
        int curr;
        System.out.printf("%d %d ", prevPrev, prev);
        for (int i = 0; i < 8; i++) {
            curr = prevPrev + prev;
            System.out.printf("%d ", curr);
            prevPrev = prev;
            prev = curr;
        }
        System.out.println("\n--");
    }
}
