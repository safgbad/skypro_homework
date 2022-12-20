package sky.pro.java.course2.exam2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Необходимо реализовать следующий метод:
//
//        1. На вход получаем список названий книг
//
//        2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
//
//        3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
//
//        4. Количество полок константное - 5 штук
//
//        5. Вернуть книги распределенные по полкам
public class Utils {
    private static final int NUMBER_OF_SHELVES = 5;

    public static Map<Integer, List<String>> distributeBooks(List<String> books) {
        if (books.size() > 20) {
            throw new TooManyBooksException();
        }
        Map<Integer, List<String>> mapOfBooks = new HashMap<>();
        List<String> sortedBooks = books.stream()
                .sorted()
                .collect(Collectors.toList());
        int defaultNumberOfBooksOnShelf = sortedBooks.size() / NUMBER_OF_SHELVES;
        int numberOfShelvesWithAdditionalBook =  sortedBooks.size() % NUMBER_OF_SHELVES;
        int lastIndex = 0;
        for (int i = 1; i <= NUMBER_OF_SHELVES; i++) {
            int numberOfBooksOnThisShelf = defaultNumberOfBooksOnShelf
                    + (i <= numberOfShelvesWithAdditionalBook ? 1 : 0);
            mapOfBooks.put(i, sortedBooks.subList(lastIndex, lastIndex + numberOfBooksOnThisShelf));
            lastIndex += numberOfBooksOnThisShelf;
        }
        return mapOfBooks;
    }
}
