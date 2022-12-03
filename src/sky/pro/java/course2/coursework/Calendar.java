package sky.pro.java.course2.coursework;

import sky.pro.java.course2.coursework.task.Repeatable;
import sky.pro.java.course2.coursework.task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Calendar {
    private final Map<Integer, Task> tasks;

    public Calendar() {
        tasks = new HashMap<>();
    }

    public boolean addTask(Task task) {
        return tasks.put(task.getId(), task) == null;
    }

    public boolean removeTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.get(id).setActive(false);
            return true;
        }
        return false;
    }

    public TreeMap<LocalTime, Task> getTasksForDay(LocalDate day) {
        TreeMap<LocalTime, Task> result = new TreeMap<>();
        LocalDateTime dayWithZeros = LocalDateTime.of(day, LocalTime.MIN);
        LocalDateTime beginningOfTheDay = dayWithZeros.minusNanos(1);
        LocalDateTime endingOfTheDay = dayWithZeros.plusDays(1);
        for (Task task : tasks.values()) {
            if (task.isActive()) {
                if (task instanceof Repeatable) {
                    LocalDateTime taskDate = ((Repeatable) task).getNextDate(beginningOfTheDay);
                    if (taskDate.isBefore(endingOfTheDay)) {
                        putTaskToMap(task, result);
                    }
                } else {
                    LocalDateTime taskDate = task.getDate();
                    if (taskDate.isAfter(beginningOfTheDay) && taskDate.isBefore(endingOfTheDay)) {
                        putTaskToMap(task, result);
                    }
                }
            }
        }
        return result;
    }

    public TreeMap<LocalTime, Task> getNotActiveTasks() {
        TreeMap<LocalTime, Task> result = new TreeMap<>();
        for (Task task : tasks.values()) {
            if (!task.isActive()) {
                putTaskToMap(task, result);
            }
        }
        return result;
    }

    private void putTaskToMap(Task task, Map<LocalTime, Task> map) {
        Task prevTask = map.put(task.getDate().toLocalTime(), task);
        int nanosCounter = 0;
        while (prevTask != null) {
            prevTask = map.put(prevTask.getDate().toLocalTime().plusNanos(++nanosCounter), prevTask);
        }
    }
}
