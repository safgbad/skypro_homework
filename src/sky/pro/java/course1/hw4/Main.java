package sky.pro.java.course1.hw4;

public class Main {
    public static void main(String[] args) {
        task1(1);
        task2(0, 2013);
        task3(2024);
        task4(100);
        task5(9);
    }

    // Task 1
    public static void task1(int clientOS) {
        switch (clientOS) {
            case 0:
                System.out.println("Установите версию приложения для iOS по ссылке");
                break;
            case 1:
                System.out.println("Установите версию приложения для Android по ссылке");
                break;
            default:
                System.out.println("ПОд операционную систему вашего устройства нет приложения");
        }
        System.out.println("--");
    }

    // Task 2
    public static void task2(int clientOS, int clientDeviceYear) {
        if ((clientOS == 0) && (clientDeviceYear < 2015)) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            System.out.println("--");
        } else if ((clientOS == 1) && (clientDeviceYear < 2015)) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
            System.out.println("--");
        } else
            task1(clientOS);
    }

    // Task 3
    public static void task3(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.printf("%d является високосным\n", year);
        } else
            System.out.printf("%d не является високосным\n", year);
        System.out.println("--");
    }

    // Task 4
    public static void task4(int deliveryDistance) {
        System.out.printf("Потребуется дней: %d\n", deliveryDistance < 20 ? 1 : 2 + (deliveryDistance - 20) / 40);
        System.out.println("--");
    }

    // Task 5
    public static void task5(int monthNumber) {
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                System.out.println("Это зимний месяц");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Это весенний месяц");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Это летний месяц");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Это осенний месяц");
                break;
            default:
                System.out.println("Некорректный номер месяца");
        }
        System.out.println("--");
    }
}
