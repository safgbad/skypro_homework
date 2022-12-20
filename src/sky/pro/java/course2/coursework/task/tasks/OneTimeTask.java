package sky.pro.java.course2.coursework.task.tasks;

import sky.pro.java.course2.coursework.task.Task;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, boolean isWork, LocalDateTime date) {
        super(title, description, isWork, date);
    }

    @Override
    protected String getType() {
        return "Однократная";
    }
}
