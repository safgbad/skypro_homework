package sky.pro.java.course2.coursework.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private final static String DELIMITER = "----------------------------------------";
    private static int counter = 1;

    private final String title;
    private final String description;
    private final boolean isWork;
    private final int id;
    protected final LocalDateTime date;

    public Task(String title, String description, boolean isWork, LocalDateTime date) {
        this.title = title;
        this.description = description;
        this.isWork = isWork;
        this.id = counter++;
        this.date = date;
    }

    public LocalDateTime getDate() {
        if (this instanceof Repeatable) {
            return ((Repeatable) this).getNextDate(LocalDateTime.now());
        } else {
            return date;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "%s, ID: %d [%s]\n" +
                "Время: %s\n" +
                "%s\n" +
                "%s",
                DELIMITER,
                title, id, isWork ? "Рабочая" : "Личная",
                date.format(DATE_FORMATTER),
                description,
                DELIMITER);
    }
}
