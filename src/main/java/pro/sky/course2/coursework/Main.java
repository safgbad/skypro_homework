package pro.sky.course2.coursework;

import pro.sky.course2.coursework.task.Task;
import pro.sky.course2.coursework.task.tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;

public class Main {
    public static final String WRONG_FORMAT = "Неверный формат ввода. Попробуйте еще раз:";
    public static final String NOT_FOUND = "Задача с таким ID отсутствует в календаре.";

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
                            runMethod(scanner, Main::inputTask);
                            break;
                        case 2:
                            runMethod(scanner, Main::editTask);
                            break;
                        case 3:
                            runMethod(scanner, Main::removeTask);
                            break;
                        case 4:
                            runMethod(scanner, Main::printTasksForTheDay);
                            break;
                        case 5:
                            runMethod(scanner, Main::printTasksForPeriod);
                            break;
                        case 6:
                            runMethod(scanner, Main::printDeletedTasks);
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

    private static void inputTask(Scanner scanner) {
        // title input
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine();
        // description input
        System.out.println("Введите описание задачи:");
        String description = scanner.nextLine();
        // isWork input
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
        // date input
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
        // creation of Task
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
            return;
        }
        throw new RuntimeException("Произошла непредвиденная ошибка. Программа завершается.");
    }

    private static void editTask(Scanner scanner) {
        int id = enterId(scanner);
        Task task = calendar.getTask(id);
        if (task != null) {
            // editing title
            System.out.println("Старое название задачи:");
            System.out.println(task.getTitle());
            System.out.println("Введите новое название (не вводите ничего, если не хотите менять)");
            String title = scanner.nextLine();
            System.out.println();
            //editing description
            System.out.println("Старое описание задачи:");
            System.out.println(task.getDescription());
            System.out.println("Введите новое описание (не вводите ничего, если не хотите менять)");
            String description = scanner.nextLine();
            System.out.println();
            // fix changes
            calendar.editTask(id, title, description);
            System.out.println("Задача успешно отредактирована!");
        } else {
            System.out.println(NOT_FOUND);
        }
    }

    private static void removeTask(Scanner scanner) {
        int id = enterId(scanner);
        if (calendar.removeTask(id)) {
            System.out.println("Задача была успешно удалена!");
        } else {
            System.out.println(NOT_FOUND);
        }
    }

    private static void printTasksForTheDay(Scanner scanner) {
        System.out.println("Введите дату (01.01.1970):");
        LocalDate date = enterDate(scanner);
        printTasksForOneDay(date);
    }

    private static void printTasksForPeriod(Scanner scanner) {
        // beginning of period
        System.out.println("Введите начало периода (01.01.1970):");
        LocalDate begin = enterDate(scanner);
        // ending of period
        System.out.println("Введите конец периода (01.01.1970):");
        LocalDate end = enterDate(scanner);
        // output
        while (begin.isBefore(end.plusDays(1))) {
            printTasksForOneDay(begin);
            begin = begin.plusDays(1);
        }
    }

    private static void printDeletedTasks(Scanner scanner) {
        System.out.println("Удаленные задания:");
        for (Task task : calendar.getNotActiveTasks().values()) {
            System.out.println(task);
        }
    }

    private static void printMenu() {
        System.out.println("\t • 1. Добавить задачу\n" +
                "\t • 2. Редактировать задачу\n" +
                "\t • 3. Удалить задачу\n" +
                "\t • 4. Получить задачи на указанный день\n" +
                "\t • 5. Показать задачи по дням\n" +
                "\t • 6. Показать удаленные задачи\n" +
                "\t • 0. Выход");
    }

    // method framing
    private static void runMethod(Scanner scanner, Consumer<Scanner> consumer) {
        scanner.nextLine();
        System.out.println("========================================");
        consumer.accept(scanner);
        System.out.println("========================================");
        System.out.println();
    }

    private static int enterId(Scanner scanner) {
        System.out.println("Введите ID задачи:");
        boolean shouldEnterAgain = true;
        int id = -1;
        while (shouldEnterAgain) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                shouldEnterAgain = false;
            } catch (NumberFormatException e) {
                System.out.println(WRONG_FORMAT);
            }
        }
        return id;
    }

    private static LocalDate enterDate(Scanner scanner) {
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
        return date;
    }

    // tasks for one day output (used for •4 and •5)
    private static void printTasksForOneDay(LocalDate date) {
        TreeMap<LocalTime, Task> tasksForTheDay = calendar.getTasksForDay(date);
        System.out.println();
        System.out.printf("Задачи на %s:\n", date.format(Task.DATE_FORMATTER));
        if (!tasksForTheDay.isEmpty()) {
            for (Task task : tasksForTheDay.values()) {
                System.out.println(task.toStringForDefiniteDay());
            }
        } else {
            System.out.println("Задач на этот день нет!");
        }
    }
}
