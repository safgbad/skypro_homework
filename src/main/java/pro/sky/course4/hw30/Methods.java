package pro.sky.course4.hw30;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Methods {
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        LinkedList<? extends T> list = stream
                .sorted(order)
                .collect(Collectors.toCollection(LinkedList::new));
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = list.getFirst();
            T max = list.getLast();
            minMaxConsumer.accept(min, max);
        }
    }

    public static int countEvenWithPrint(List<Integer> list) {
        List<Integer> evenList = list.stream()
                .filter(integer -> integer % 2 == 0)
                .toList();
        evenList.forEach(even -> System.out.print(even + " "));

        return evenList.size();
    }
}
