package sky.pro.java.course1.hw12;

public class Library {
    private Book[] bookArray;

    public Library(int size) {
        bookArray = new Book[size];
    }

    public boolean addBook(Book book) {
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] == null) {
                bookArray[i] = book;
                return true;
            }
        }
        return false;
    }

    public void printBooks() {
        for (Book book : bookArray) {
            if (book != null)
                System.out.println(book);
        }
    }

    private int indexOf(String name) {
        for (int i = 0; i < bookArray.length; i++) {
            if ((bookArray[i] != null) && (bookArray[i].getName().equalsIgnoreCase(name)))
                return i;
        }
        return -1;
    }

    public void printBookInformationByName(String name) {
        int index = indexOf(name);
        if (index == -1)
            System.out.printf("The %s hasn't found in library\n", name);
        else {
            System.out.printf("%s by %s %s was published in %d\n", bookArray[index].getName(),
                    bookArray[index].getAuthor().getFirstName(), bookArray[index].getAuthor().getLastName(),
                    bookArray[index].getYear());
        }
    }

    public boolean setYear(String name, int year) {
        int index = indexOf(name);
        if (index == -1)
            return false;
        else
            bookArray[index].setYear(year);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Library:");
        for (Book book : bookArray) {
            if (book != null)
                stringBuilder.append("\n").append(book);
        }
        return stringBuilder.toString();
    }
}
