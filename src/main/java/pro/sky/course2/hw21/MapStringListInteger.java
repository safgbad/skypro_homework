package pro.sky.course2.hw21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStringListInteger {
    private static final Map<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            String str = "str#" + i;
            List<Integer> list = List.of(randomValue(), randomValue(), randomValue());
            map.put(str, list);
            System.out.println('"' + str + "\" -> " + list);
        }
        Map<String, Integer> mapNew = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> sum(entry.getValue())));
        System.out.println();
        for (Map.Entry<String, Integer> entry : mapNew.entrySet()) {
            System.out.println('"' + entry.getKey() + "\" -> " + entry.getValue());
        }
    }

    public static int randomValue() {
        return (int) (1001 * Math.random());
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}
