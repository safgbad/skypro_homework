package sky.pro.java.course1.coursework;

import java.util.Objects;

public class Employee {
    private static int employeesCounter = 0;

    private final int id;
    private final String fullName;
    private Department department;
    private double salary;

    public Employee(String fullName, int departmentID, double salary) {
        id = employeesCounter++;
        this.fullName = fullName;
        this.department = Department.getDepartmentByID(departmentID);
        this.salary = salary;
    }

    public Employee(String fullName, Department department, double salary) {
        id = employeesCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public Employee(double salary) {
        id = -1;
        fullName = "";
        department = null;
        this.salary = salary;
    }

    public int getID() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentID() {
        return department.getDepartmentID();
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartmentID(int departmentID) {
        this.department = Department.getDepartmentByID(departmentID);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toStringWithoutDepartment() {
        return String.format("ID: %4d; ФИО: %50s; Зарплата: %10.2f", id, fullName, salary);
    }

    @Override
    public String toString() {
        return String.format("ID: %4d; ФИО: %50s; ID отдела: %2d; Зарплата: %10.2f", id, fullName, department.getDepartmentID(), salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && fullName.equals(employee.fullName) && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, salary);
    }
}
