package sky.pro.java.course1.hw12;

import java.util.Objects;

public class Book {
    private final String NAME;
    private final Author AUTHOR;
    private int year;

    public Book(String name, Author author, int year) {
        this.NAME = name;
        this.AUTHOR = author;
        this.year = year;
    }

    public String getName() {
        return NAME;
    }

    public Author getAuthor() {
        return AUTHOR;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("[Book] {%s: \"%s\", %d}", AUTHOR, NAME, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && NAME.equals(book.NAME) && AUTHOR.equals(book.AUTHOR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, AUTHOR, year);
    }
}
