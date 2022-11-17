package sky.pro.java.course2.coursework.tasks;

import java.time.LocalDateTime;

public interface Repeatable {
    LocalDateTime getNextDate(LocalDateTime fromDate);
}
