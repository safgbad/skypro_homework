package sky.pro.java.course2.hw16.stuff;

import sky.pro.java.course2.hw16.transport.Transport;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServiceStation {
    private final Queue<Queueable> queue;

    public ServiceStation() {
        queue = new LinkedList<>();
    }

    public <T extends Transport & Queueable> boolean addToQueue(T queueable) {
        if (!queueable.isInQueue()) {
            queue.add(queueable);
            queueable.setIsInQueue(true);
            return true;
        }
        return false;
    }

    public <T extends Transport> void addToQueue(List<T> transports) {
        for (T transport : transports) {
            if (transport instanceof Queueable) {
                addToQueue((Transport & Queueable) transport);
            }
        }
    }

    public boolean toService() {
        if (!queue.isEmpty()) {
            Queueable queueable = queue.remove();
            queueable.setIsInQueue(false);
            ((Transport) queueable).getDiagnosed();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Очередь на станции тех. обслуживания:");
        if (queue.isEmpty()) {
            stringBuilder.append("\n\tОчередь пуста");
        } else {
            int counter = 0;
            for (Queueable queueable : queue) {
                stringBuilder.append("\n\t").append(++counter).append(". ")
                        .append(((Transport) queueable).getBrand()).append(' ')
                        .append(((Transport) queueable).getModel());
            }
        }
        return stringBuilder.toString();
    }
}
