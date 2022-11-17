package sky.pro.java.course2.coursework.tasks;

import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable {
    public WeeklyTask(String TITLE, String DESCRIPTION, boolean IS_WORK, LocalDateTime DATE) {
        super(TITLE, DESCRIPTION, IS_WORK, DATE);
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime fromDate) {
        LocalDateTime result = this.getDATE();
        while (result.isAfter(fromDate)) {
            result = result.plusWeeks(1);
        }
        return result;
    }
}
