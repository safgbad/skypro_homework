package sky.pro.java.course2.coursework.tasks;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String TITLE, String DESCRIPTION, boolean IS_WORK, LocalDateTime DATE) {
        super(TITLE, DESCRIPTION, IS_WORK, DATE);
    }
}
