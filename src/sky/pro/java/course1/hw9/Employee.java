package sky.pro.java.course1.hw9;

public class Employee {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String fullName;

    public Employee(String firstName, String middleName, String lastName) {
        this.firstName = firstName.replaceAll("ё", "е");
        this.middleName = middleName.replaceAll("ё", "е");
        this.lastName = lastName.replaceAll("ё", "е");
        fullName = this.lastName + " " + this.firstName + " " + this.middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullNameForReport() {
        return fullName.toUpperCase();
    }
}
