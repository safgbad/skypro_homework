package sky.pro.java.course2.coursework.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final static String DELIMITER = "----------------------------------------";
    private static int counter = 1;

    private String title;
    private String description;
    private final boolean isWork;
    private final int id;
    protected final LocalDateTime date;
    private boolean isActive;

    public Task(String title, String description, boolean isWork, LocalDateTime date) {
        setTitle(title);
        setDescription(description);
        this.isWork = isWork;
        this.id = counter++;
        this.date = date;
        isActive = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        return String.format("\t%s\n" +
                "\t%s, ID: %d [%s, %s]\n" +
                "\tВремя: %s\n" +
                "\t%s\n" +
                "\t%s",
                DELIMITER,
                title, id, isWork ? "Рабочая" : "Личная", getType(),
                date.format(DATE_TIME_FORMATTER),
                description,
                DELIMITER);
    }

    public String toStringForDefiniteDay() {
        return String.format("\t%s\n" +
                        "\t%s, ID: %d [%s, %s]\n" +
                        "\tВремя: %s\n" +
                        "\t%s\n" +
                        "\t%s",
                DELIMITER,
                title, id, isWork ? "Рабочая" : "Личная", getType(),
                date.format(TIME_FORMATTER),
                description,
                DELIMITER);
    }
}
