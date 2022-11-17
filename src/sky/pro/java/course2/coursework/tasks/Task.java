package sky.pro.java.course2.coursework.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.LONG;

public abstract class Task {
    private final static String DELIMITER = "----------------------------------------";
    private static int counter = 1;

    private final String TITLE;
    private final String DESCRIPTION;
    private final boolean IS_WORK;
    private final int ID;
    private final LocalDateTime DATE;

    public Task(String TITLE, String DESCRIPTION, boolean IS_WORK, LocalDateTime DATE) {
        this.TITLE = TITLE;
        this.DESCRIPTION = DESCRIPTION;
        this.IS_WORK = IS_WORK;
        this.ID = ++counter;
        this.DATE = DATE;
    }

    public LocalDateTime getDATE() {
        return DATE;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "%s, ID: %d [%s]\n" +
                "Время: %s\n" +
                "%s\n" +
                "%s",
                DELIMITER,
                TITLE, ID, IS_WORK ? "Рабочая" : "Личная",
                DATE.format(DateTimeFormatter.ofLocalizedDateTime(LONG, LONG)),
                DESCRIPTION,
                DELIMITER);
    }
}
