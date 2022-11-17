package sky.pro.java.course2.coursework;

import sky.pro.java.course2.coursework.tasks.Repeatable;
import sky.pro.java.course2.coursework.tasks.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calendar {
    private Map<Integer, Task> tasks;

    public Calendar() {
        tasks = new HashMap<>();
    }

    public boolean addTask(Task task) {
        if (tasks.put(task.getID(), task) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTask(int id) {
        if (tasks.remove(id) != null) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Task> getTasksForDay(LocalDate day) {
        ArrayList<Task> result = new ArrayList<>();
        LocalDateTime dayWithZeros = LocalDateTime.of(day, LocalTime.MIN);
        LocalDateTime beginningOfTheDay = dayWithZeros.minusNanos(1);
        LocalDateTime endingOfTheDay = dayWithZeros.plusDays(1);
        for (Integer key : tasks.keySet()) {
            Task task = tasks.get(key);
            if (task instanceof Repeatable) {
                LocalDateTime taskDate = ((Repeatable) task).getNextDate(beginningOfTheDay);
                if (taskDate.isBefore(endingOfTheDay)) {
                    result.add(task);
                }
            } else {
                LocalDateTime taskDate = task.getDATE();
                if (taskDate.isAfter(beginningOfTheDay) && taskDate.isBefore(endingOfTheDay)) {
                    result.add(task);
                }
            }
        }
        return result;
    }
}
