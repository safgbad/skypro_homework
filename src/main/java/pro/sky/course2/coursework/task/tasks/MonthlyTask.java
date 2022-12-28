package pro.sky.course2.coursework.task.tasks;

import pro.sky.course2.coursework.task.Repeatable;
import pro.sky.course2.coursework.task.Task;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(String title, String description, boolean isWork, LocalDateTime date) {
        super(title, description, isWork, date);
    }

    @Override
    protected String getType() {
        return "Ежемесячная";
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
