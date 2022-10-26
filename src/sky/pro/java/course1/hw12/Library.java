package sky.pro.java.course1.hw12;

public class Library {
    private final Book[] BOOK_ARRAY;

    public Library(int size) {
        BOOK_ARRAY = new Book[size];
    }

    public boolean addBook(Book book) {
        for (int i = 0; i < BOOK_ARRAY.length; i++) {
            if (BOOK_ARRAY[i] == null) {
                BOOK_ARRAY[i] = book;
                return true;
            }
        }
        return false;
    }

    public void printBooks() {
        for (Book book : BOOK_ARRAY) {
            if (book != null)
                System.out.println(book);
        }
    }

    private int indexOf(String name) {
        for (int i = 0; i < BOOK_ARRAY.length; i++) {
            if ((BOOK_ARRAY[i] != null) && (BOOK_ARRAY[i].getName().equalsIgnoreCase(name)))
                return i;
        }
        return -1;
    }

    public void printBookInformationByName(String name) {
        int index = indexOf(name);
        if (index == -1)
            System.out.printf("The %s hasn't found in library\n", name);
        else {
            System.out.printf("%s by %s %s was published in %d\n", BOOK_ARRAY[index].getName(),
                    BOOK_ARRAY[index].getAuthor().getFirstName(), BOOK_ARRAY[index].getAuthor().getLastName(),
                    BOOK_ARRAY[index].getYear());
        }
    }

    public boolean setYear(String name, int year) {
        int index = indexOf(name);
        if (index == -1)
            return false;
        else
            BOOK_ARRAY[index].setYear(year);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Library:");
        for (Book book : BOOK_ARRAY) {
            if (book != null)
                stringBuilder.append("\n").append(book);
        }
        return stringBuilder.toString();
    }
}
