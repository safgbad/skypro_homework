package sky.pro.java.course2.coursework;

import sky.pro.java.course2.coursework.task.Task;
import sky.pro.java.course2.coursework.task.tasks.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static Calendar calendar = new Calendar();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            if (inputTask(scanner)) {
                                break;
                            } else {
                                break label;
                            }
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static boolean inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println();
        System.out.println("========================================");
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine();

        System.out.println("Введите описание задачи:");
        String description = scanner.nextLine();

        boolean isWork;
        System.out.println("Эта задача рабочая?");
        switch (scanner.nextLine()) {
            case "1":
            case "да":
            case "д":
            case "y":
            case "yes":
            case "Y":
            case "YES":
                isWork = true;
                break;
            default:
                isWork = false;
        }

        LocalDateTime date = null;
        System.out.println("Введите дату и время задачи (01.01.1970 00:00:00):");

        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                String str = scanner.nextLine();
                date = LocalDateTime.parse(str, Task.DATE_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат ввода. Попробуйте еще раз:");
            }
        }

        Task task;
        System.out.println("Повторяемость задания:");
        System.out.println("\t • 0 – не повторяется (default)");
        System.out.println("\t • 1 – ежедневно");
        System.out.println("\t • 2 – еженедельно");
        System.out.println("\t • 3 – ежемесячно");
        System.out.println("\t • 4 – ежегодно");
        switch (scanner.next()) {
            case "1":
                task = new DailyTask(title, description, isWork, date);
                break;
            case "2":
                task = new WeeklyTask(title, description, isWork, date);
                break;
            case "3":
                task = new MonthlyTask(title, description, isWork, date);
                break;
            case "4":
                task = new YearlyTask(title, description, isWork, date);
                break;
            default:
                task = new OneTimeTask(title, description, isWork, date);
        }
        System.out.println("========================================");
        System.out.println();
        if (calendar.addTask(task)) {
            System.out.println("Задача успешно добавлена!");
            System.out.println();
            return true;
        }
        System.out.println("Произошла непредвиденная ошибка. Программа завершается.");
        return false;
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n" +
                "2. Удалить задачу\n" +
                "3. Получить задачу на указанный день\n" +
                "0. Выход");
    }
}
