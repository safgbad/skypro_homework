package sky.pro.java.course1.coursework;

import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;
    private int numberOfEmployees;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
        numberOfEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null)
                numberOfEmployees++;
        }
    }

    public int getIndex(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getFullName().equals(fullName)))
                return i;
        }
        return -1;
    }

    public int getIndex(int id) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getID() == id))
                return i;
        }
        return -1;
    }

    private EmployeeBook filterByDepartment(int departmentID) {
        return new EmployeeBook(Arrays.stream(employees).filter(x -> (x != null) && (x.getDepartmentID() == departmentID)).toArray(Employee[]::new));
    }

    public void printArray() {
        for (var employee : employees) {
            if (employee != null)
                System.out.println(employee);
        }
    }

    public void printArray(int departmentID) {
        for (Employee employee : this.filterByDepartment(departmentID).employees) {
            System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public void printNames() {
        for (Employee employee : employees) {
            if (employee != null)
                System.out.println(employee.getFullName());
        }
    }

    public void printNames(int departmentID) {
        this.filterByDepartment(departmentID).printNames();
    }

    public void printArrayCategorizedByDepartmentID() {
        for (int i = 0; i <= 5; i++) {
            System.out.printf("Список сотрудников отдела №%d:\n", i);
            this.printNames(i);
            System.out.println("--");
        }
    }

    public double sumSalaries() {
        double result = 0;
        for (var employee : employees)
            result += employee.getSalary();
        return result;
    }

    public double sumSalaries(int departmentID) {
        return this.filterByDepartment(departmentID).sumSalaries();
    }

    public double getAverageSalary() {
        if (numberOfEmployees == 0)
            return 0;
        else
            return this.sumSalaries() / numberOfEmployees;
    }

    public double getAverageSalary(int departmentID) {
        return this.filterByDepartment(departmentID).getAverageSalary();
    }

    public Employee findEmployeeWithMinSalary() {
        if (employees.length > 0) {
            Employee result = employees[0];
            for (var employee : employees) {
                if (result.getSalary() > employee.getSalary())
                    result = employee;
            }
            return result;
        }
        else
            return new Employee("-", -1, 0);
    }

    public Employee findEmployeeWithMinSalary(int departmentID) {
        return this.filterByDepartment(departmentID).findEmployeeWithMinSalary();
    }

    public Employee findEmployeeWithMaxSalary() {
        if (employees.length > 0) {
            Employee result = employees[0];
            for (var employee : employees) {
                if (result.getSalary() < employee.getSalary())
                    result = employee;
            }
            return result;
        }
        else
            return null;
    }

    public Employee findEmployeeWithMaxSalary(int departmentID) {
        return this.filterByDepartment(departmentID).findEmployeeWithMaxSalary();
    }

    public void findEmployeesWithSalaryLessThan(double threshold) {
        for (Employee employee : employees) {
            if (employee.getSalary() < threshold)
                System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public void findEmployeesWithSalaryMoreThan(double threshold) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= threshold)
                System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public boolean addEmployee(String fullName, int departmentID, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, departmentID, salary);
                numberOfEmployees++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(String fullName) {
        try {
            employees[getIndex(fullName)] = null;
            numberOfEmployees--;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean deleteEmployee(int id) {
        try {
            employees[getIndex(id)] = null;
            numberOfEmployees--;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean deleteEmployee(int id, String fullName) {
        int index = getIndex(fullName);
        if (index == getIndex(id)) {
            try {
                employees[index] = null;
                numberOfEmployees--;
                return true;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        } else
            return false;
    }

    public boolean setSalary(String fullName, double salary) {
        try {
            employees[getIndex(fullName)].setSalary(salary);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean setDepartmentID(String fullName, int departmentID) {
        try {
            employees[getIndex(fullName)].setDepartmentID(departmentID);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public void indexSalaries(double rate) {
        double factor = rate / 100;
        for (Employee employee : employees) {
            double employeeSalary = employee.getSalary();
            employee.setSalary(employeeSalary + factor * employeeSalary);
        }
    }

    public void indexSalaries(double rate, int departmentID) {
        this.filterByDepartment(departmentID).indexSalaries(rate);
    }
}
