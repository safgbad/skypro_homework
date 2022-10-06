package sky.pro.java.course1.hw10;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        int year = 2022;
        if (isLeap(year))
            System.out.printf("%d год – високосный\n", year);
        else
            System.out.printf("%d год – не високосный\n", year);
        System.out.println("--");

        // Task 2
        System.out.println("Task 2");
        chooseAppVersion(2, 2015);
        System.out.println("--");

        // Task 3
        System.out.println("Task 3");
        int deliveryDistance = 21;
        System.out.printf("При расстоянии %d км для доставки потребуется дней: %d\n", deliveryDistance, calculateDeliveryPeriod(deliveryDistance));
        System.out.println("--");
    }

    public static boolean isLeap(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    public static void chooseAppVersion(int clientOS, int clientDeviceYear) {
        String operatingSystem;
        switch (clientOS) {
            case 0:
                operatingSystem = "iOS";
                break;
            case 1:
                operatingSystem = "Android";
                break;
            default:
                System.out.println("Ваше устройство не поддерживается");
                return;
        }
        String lite = "";
        if (clientDeviceYear < LocalDate.now().getYear())
            lite = "облегченную ";
        System.out.printf("Установите %sверсию приложения для %s по ссылке\n", lite, operatingSystem);
    }

    public static int calculateDeliveryPeriod(int deliveryDistance) {
        int oneDayZoneDistance = 20;
        int raisingDistance = 40;
        return deliveryDistance <= oneDayZoneDistance ? 1 : 2 + (deliveryDistance - oneDayZoneDistance - 1) / raisingDistance;
    }
}
