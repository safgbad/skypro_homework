package sky.pro.java.course2.coursework.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final static String DELIMITER = "----------------------------------------";
    private static int counter = 1;

    private final String title;
    private final String description;
    private final boolean isWork;
    private final int id;
    protected final LocalDateTime date;
    private boolean isActive;

    public Task(String title, String description, boolean isWork, LocalDateTime date) {
        this.title = title;
        this.description = description;
        this.isWork = isWork;
        this.id = counter++;
        this.date = date;
        isActive = true;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    protected abstract String getType();

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "%s, ID: %d [%s, %s]\n" +
                "Время: %s\n" +
                "%s\n" +
                "%s",
                DELIMITER,
                title, id, isWork ? "Рабочая" : "Личная", getType(),
                date.format(DATE_TIME_FORMATTER),
                description,
                DELIMITER);
    }

    public String toStringForDefiniteDay() {
        return String.format("%s\n" +
                        "%s, ID: %d [%s, %s]\n" +
                        "Время: %s\n" +
                        "%s\n" +
                        "%s",
                DELIMITER,
                title, id, isWork ? "Рабочая" : "Личная", getType(),
                date.format(TIME_FORMATTER),
                description,
                DELIMITER);
    }
}
