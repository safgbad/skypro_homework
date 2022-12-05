package sky.pro.java.course2.hw16.utility;

import java.util.List;

public class Printer {
    public static void printObjects(List objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
