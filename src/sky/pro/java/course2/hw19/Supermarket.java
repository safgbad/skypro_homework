package sky.pro.java.course2.hw19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Supermarket {
    public static final String CUSTOMER = "Customer";
    public static int NUMBER_OF_QUEUES = 2;
    public static final int CAPACITY = 5;
    public static final List<BlockingQueue<String>> queues = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_QUEUES; i++) {
            queues.add(new LinkedBlockingQueue<>(CAPACITY));
            fillTheQueue(queues.get(i));
        }
        printQueues();
    }

    public static void fillTheQueue(BlockingQueue<String> queue) {
        int numberOfPeople = (int) (CAPACITY * Math.random());
        for (int i = 0; i <= numberOfPeople; i++) {
            queue.add(CUSTOMER);
        }
    }

    public static boolean addHuman() {
        Integer targetIndex = null;
        for (int i = 0; i < queues.size(); i++) {
            if (targetIndex != null
                    && queues.get(i).remainingCapacity() > queues.get(targetIndex).remainingCapacity()
                    || targetIndex == null && queues.get(i).remainingCapacity() > 0) {
                targetIndex = i;
            }
        }
        if (targetIndex != null) {
            queues.get(targetIndex).add(CUSTOMER);
            return true;
        }
        System.out.println("Кассы перегружены, зовите Галю");
        System.out.println();
        queues.add(new LinkedBlockingQueue<>(CAPACITY));
        addHuman();
        return false;
    }

    public static boolean removeHuman() {
        ArrayList<BlockingQueue<String>> notEmptyQueues = new ArrayList<>();
        for (BlockingQueue<String> queue : queues) {
            if (!queue.isEmpty()) {
                notEmptyQueues.add(queue);
            }
        }
        if (notEmptyQueues.size() == 0) {
            return false;
        }
        int random = (int) (notEmptyQueues.size() * Math.random());
        notEmptyQueues.get(random).remove();
        return true;
    }

    public static void printQueues() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_QUEUES; i++) {
            stringBuilder.append(String.format("%-20s", "Очередь №" + (i + 1)));
        }
        System.out.println(stringBuilder);
        for (int i = 0; i < CAPACITY; i++) {
            stringBuilder = new StringBuilder();
            for (BlockingQueue<String> queue : queues) {
                stringBuilder.append(String.format("%-20s",
                        queue.remainingCapacity() < CAPACITY - i ? CUSTOMER : "<blank>"));
            }
            System.out.println(stringBuilder);
        }
        System.out.println();
    }
}
