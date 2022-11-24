package sky.pro.java.course2.hw16.utility;

import java.util.ArrayList;

public class Printer {
    public static void printObjects(ArrayList objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
