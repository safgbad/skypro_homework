package pro.sky.course1.hw12;

import java.util.Objects;

public class Author {
    private final String FIRSTNAME;
    private final String LASTNAME;

    public Author(String firstName, String lastName) {
        this.FIRSTNAME = firstName;
        this.LASTNAME = lastName;
    }

    public String getFirstName() {
        return FIRSTNAME;
    }

    public String getLastName() {
        return LASTNAME;
    }

    @Override
    public String toString() {
        return String.format("[Author] %s %s", FIRSTNAME, LASTNAME);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return FIRSTNAME.equals(author.FIRSTNAME) && LASTNAME.equals(author.LASTNAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIRSTNAME, LASTNAME);
    }
}
