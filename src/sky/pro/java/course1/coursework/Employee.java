package sky.pro.java.course1.coursework;

import java.util.Arrays;

public class Employee {
    private static int employeesCounter = 0;

    private final int id;
    private final String fullName;
    private int departmentID;
    private double salary;

    private static Employee[] filterByDepartment(Employee[] employees, int departmentID) {
        return Arrays.stream(employees).filter(x -> x.departmentID == departmentID).toArray(Employee[]::new);
    }

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

    public static void printArray(Employee[] employees) {
        for (var employee : employees)
            System.out.println(employee.toString());
    }

    public static void printArray(Employee[] employees, int departmentID) {
        Employee[] employeesInDepartment = filterByDepartment(employees, departmentID);
        for (Employee employee : employeesInDepartment)
            System.out.println(employee.toStringWithoutDepartment());
    }

    public static double sumSalaries(Employee[] employees) {
        double result = 0;
        for (var employee : employees)
            result += employee.salary;
        return result;
    }

    public static double sumSalaries(Employee[] employees, int departmentID) {
        return sumSalaries(filterByDepartment(employees, departmentID));
    }

    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
        if (employees.length > 0) {
            Employee result = employees[0];
            for (var employee : employees) {
                if (result.salary > employee.salary)
                    result = employee;
            }
            return result;
        }
        else
            return new Employee("-", -1, 0);
    }

    public static Employee findEmployeeWithMinSalary(Employee[] employees, int departmentID) {
        return findEmployeeWithMinSalary(filterByDepartment(employees, departmentID));
    }

    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
        if (employees.length > 0) {
            Employee result = employees[0];
            for (var employee : employees) {
                if (result.salary < employee.salary)
                    result = employee;
            }
            return result;
        }
        else
            return new Employee("-", -1, 0);
    }

    public static Employee findEmployeeWithMaxSalary(Employee[] employees, int departmentID) {
        return findEmployeeWithMaxSalary(filterByDepartment(employees, departmentID));
    }

    public static double getAverageSalary(Employee[] employees) {
        return sumSalaries(employees) / employees.length;
    }

    public static double getAverageSalary(Employee[] employees, int departmentID) {
        return getAverageSalary(filterByDepartment(employees, departmentID));
    }

    public static void printNames(Employee[] employees) {
        for (Employee employee : employees)
            System.out.println(employee.fullName);
    }

    public static void indexSalaries(Employee[] employees, double rate) {
        double factor = rate / 100;
        for (Employee employee : employees)
            employee.salary = employee.salary + factor * employee.salary;
    }

    public static void indexSalaries(Employee[] employees, double rate, int departmentID) {
        indexSalaries(filterByDepartment(employees, departmentID), rate);
    }

    public static void findEmployeesWithSalaryLessThan(Employee[] employees, double threshold) {
        for (Employee employee : employees) {
            if (employee.salary < threshold)
                System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public static void findEmployeesWithSalaryMoreThan(Employee[] employees, double threshold) {
        for (Employee employee : employees) {
            if (employee.salary >= threshold)
                System.out.println(employee.toStringWithoutDepartment());
        }
    }
}
