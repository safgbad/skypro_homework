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

    public static void printArray(Employee[] employees) {
        for (var employee : employees)
            System.out.println(employee.toString());
    }

    public static double sumSalaries(Employee[] employees) {
        double result = 0;
        for (var employee : employees)
            result += employee.salary;
        return result;
    }

    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
        if (employees.length > 0) {
            Employee result = employees[0];
            for (var employee : employees)
                if (result.salary > employee.salary)
                    result = employee;
            return result;
        }
        else
            return new Employee("-", -1, 0);
    }

    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
        if (employees.length > 0) {
            Employee result = employees[0];
            for (var employee : employees)
                if (result.salary < employee.salary)
                    result = employee;
            return result;
        }
        else
            return new Employee("-", -1, 0);
    }

    public static double getAverageSalary(Employee[] employees) {
        return sumSalaries(employees) / employees.length;
    }

    public static void printNames(Employee[] employees) {
        for (Employee employee : employees)
            System.out.println(employee.fullName);
    }
}
