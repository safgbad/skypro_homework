package sky.pro.java.course2.coursework;

import sky.pro.java.course2.coursework.task.Task;
import sky.pro.java.course2.coursework.task.tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static final String WRONG_FORMAT = "Неверный формат ввода. Попробуйте еще раз:";

    public static Calendar calendar = new Calendar();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Выберите пункт меню: ");
                printMenu();
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
                            removeTask(scanner);
                            break;
                        case 3:
                            printTasksForTheDay(scanner);
                            break;
                        case 4:
                            printDeletedTasks(scanner);
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
                date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println(WRONG_FORMAT);
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
        if (calendar.addTask(task)) {
            System.out.println("Задача успешно добавлена!");
            System.out.println("========================================");
            System.out.println();
            return true;
        }
        System.out.println("Произошла непредвиденная ошибка. Программа завершается.");
        return false;
    }

    private static void removeTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Введите ID удаляемой задачи:");
        boolean shouldEnterAgain = true;
        int id = 0;
        while (shouldEnterAgain) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                shouldEnterAgain = false;
            } catch (NumberFormatException e) {
                System.out.println(WRONG_FORMAT);
            }
        }
        if (calendar.removeTask(id)) {
            System.out.println("Задача была успешно удалена!");
        } else {
            System.out.println("Задача с таким ID отсутствует в календаре.");
        }
        System.out.println("========================================");
        System.out.println();
    }

    private static void printTasksForTheDay(Scanner scanner) {
        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Введите дату (01.01.1970):");
        boolean shouldEnterAgain = true;
        LocalDate date = null;
        while (shouldEnterAgain) {
            try {
                date = LocalDate.parse(scanner.nextLine(), Task.DATE_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println(WRONG_FORMAT);
            }
        }
        TreeMap<LocalTime, Task> tasksForTheDay = calendar.getTasksForDay(date);
        System.out.println();
        System.out.printf("Задания на %s:\n", date.format(Task.DATE_FORMATTER));
        for (Task task : tasksForTheDay.values()) {
            System.out.println(task.toStringForDefiniteDay());
        }
        System.out.println("========================================");
        System.out.println();
    }

    private static void printDeletedTasks(Scanner scanner) {
        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Удаленные задания:");
        for (Task task : calendar.getNotActiveTasks().values()) {
            System.out.println(task);
        }
        System.out.println("========================================");
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("\t • 1. Добавить задачу\n" +
                "\t • 2. Удалить задачу\n" +
                "\t • 3. Получить задачи на указанный день\n" +
                "\t • 4. Показать удаленные задачи\n" +
                "\t • 0. Выход");
    }
}
