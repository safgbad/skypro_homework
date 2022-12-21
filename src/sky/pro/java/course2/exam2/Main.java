package sky.pro.java.course2.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> books = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            books.add(line);
            line = scanner.nextLine();
        }
        Map<Integer, List<String>> mapOfBooks;
        try {
            mapOfBooks = Utils.distributeBooks(books);
        } catch (TooManyBooksException e) {
            mapOfBooks = Utils.distributeBooks(books.subList(0, 20));
        }
        for (Map.Entry<Integer, List<String>> entry : mapOfBooks.entrySet()) {
            System.out.println(entry.getKey() + " полка: " + entry.getValue());
        }
    }
}
