package sky.pro.java.course2.coursework.task;

import java.time.LocalDateTime;

public interface Repeatable {
    LocalDateTime getNextDate(LocalDateTime fromDate);
}
