package sky.pro.java.course1.coursework;

public class Employee {
    private static int employeesCounter = 0;

    private final int id;
    private final String fullName;
    private int departmentID;
    private double salary;

    public int getID() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String fullName, int departmentID, double salary) {
        id = employeesCounter++;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.salary = salary;
    }

    public String toString() {
        return String.format("ID: %d; ФИО: %s; ID отдела: %d; Зарплата: %.2f", id, fullName, departmentID, salary);
    }

    public String toStringWithoutDepartment() {
        return String.format("ID: %d; ФИО: %s; Зарплата: %.2f", id, fullName, salary);
    }
}
