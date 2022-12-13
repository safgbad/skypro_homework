package sky.pro.java.course2.hw21;

import java.util.*;

public class MapIntegerString {
    private static final Map<Integer, String> map = new HashMap<>();
    private static final Map<Integer, Integer> mapOrder = new HashMap<>();
    private static int counter = 0;

    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            String str = "str#" + i;
            map.put(i, str);
            mapOrder.put(i, ++counter);
        }
        map.entrySet().stream()
                .sorted(Comparator.comparing(entry -> mapOrder.get(entry.getKey())))
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + '"' + entry.getValue() + '"'));
    }
}
