package pro.sky.course2.coursework.task;

import java.time.LocalDateTime;

public interface Repeatable {
    LocalDateTime getNextDate(LocalDateTime fromDate);
}
