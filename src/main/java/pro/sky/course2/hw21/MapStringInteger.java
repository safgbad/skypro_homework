package pro.sky.course2.hw21;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapStringInteger {
    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            map.put("str#" + i, i);
        }
        put("str#21", 21);
        put("str#21", 22);
        put("str#21", 22);
    }

    public static void put(String string, Integer integer) {
        if (Objects.equals(map.put(string, integer), integer)) {
            throw new RuntimeException();
        }
    }
}
