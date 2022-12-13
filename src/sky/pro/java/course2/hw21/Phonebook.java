package sky.pro.java.course2.hw21;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private static final Map<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            phonebook.put("Secondname#" + i + " Firstname#" + i, "+790000000" + (10 + i));
        }
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
