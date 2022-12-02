package sky.pro.java.course2.coursework.task.tasks;

import sky.pro.java.course2.coursework.task.Repeatable;
import sky.pro.java.course2.coursework.task.Task;

import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable {
    public YearlyTask(String title, String description, boolean isWork, LocalDateTime date) {
        super(title, description, isWork, date);
    }

    @Override
    protected String getType() {
        return "Ежегодная";
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime fromDate) {
        LocalDateTime result = date;
        while (result.isBefore(fromDate)) {
            result = result.plusYears(1);
        }
        return result;
    }
}
