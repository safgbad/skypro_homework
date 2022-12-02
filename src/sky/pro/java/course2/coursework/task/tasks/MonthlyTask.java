package sky.pro.java.course2.coursework.task.tasks;

import sky.pro.java.course2.coursework.task.Repeatable;
import sky.pro.java.course2.coursework.task.Task;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(String title, String description, boolean isWork, LocalDateTime date) {
        super(title, description, isWork, date);
    }

    @Override
        public LocalDateTime getNextDate(LocalDateTime fromDate) {
        LocalDateTime result = date;
        while (result.isBefore(fromDate)) {
            result = result.plusMonths(1);
        }
        return result;
    }
}
