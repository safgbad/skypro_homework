package sky.pro.java.course2.coursework.task.tasks;

import sky.pro.java.course2.coursework.task.Repeatable;
import sky.pro.java.course2.coursework.task.Task;

import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable {
    public DailyTask(String title, String description, boolean isWork, LocalDateTime date) {
        super(title, description, isWork, date);
    }

    @Override
    protected String getType() {
        return "Ежедневная";
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime fromDate) {
        LocalDateTime result = date;
        while (result.isBefore(fromDate)) {
            result = result.plusDays(1);
        }
        return result;
    }
}
