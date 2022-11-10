package sky.pro.java.course1.coursework;

import java.util.*;

public class EmployeeBook {
    private final Map<String, Employee> EMPLOYEES;

    public EmployeeBook(Map<String, Employee> employees) {
        this.EMPLOYEES = employees;
        this.EMPLOYEES.remove(null);
        Set<String> set = new HashSet<>(Set.copyOf(this.EMPLOYEES.keySet()));
        for (String key : set) {
            if (this.EMPLOYEES.get(key) == null) {
                this.EMPLOYEES.remove(key);
            }
        }
    }

    public EmployeeBook(Employee[] employees) {
        this.EMPLOYEES = new HashMap<>();
        for (Employee employee : employees) {
            this.EMPLOYEES.put(employee.getFullName(), employee);
        }
    }

    public void addEmployee(String fullName, int departmentID, double salary) {
        EMPLOYEES.put(fullName, new Employee(fullName, departmentID, salary));
    }

    public void addEmployee(String fullName, Department department, double salary) {
        EMPLOYEES.put(fullName, new Employee(fullName, department, salary));
    }

    public boolean deleteEmployee(String fullName) {
        return EMPLOYEES.remove(fullName) != null;
    }

    public boolean deleteEmployee(int id) {
        String targetName = null;
        for (String name : EMPLOYEES.keySet()) {
            if (EMPLOYEES.get(name).getID() == id) {
                targetName = name;
            }
        }
        return deleteEmployee(targetName);
    }

    public boolean deleteEmployee(int id, String fullName) {
        Employee employee = EMPLOYEES.get(fullName);
        if (employee != null && employee.getID() == id) {
            EMPLOYEES.remove(fullName);
            return true;
        } else {
            return false;
        }
    }

    public boolean setSalary(String fullName, double salary) {
        if (EMPLOYEES.containsKey(fullName)) {
            EMPLOYEES.get(fullName).setSalary(salary);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDepartment(String fullName, int departmentID) {
        if (EMPLOYEES.containsKey(fullName)) {
            EMPLOYEES.get(fullName).setDepartmentID(departmentID);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDepartment(String fullName, Department department) {
        if (EMPLOYEES.containsKey(fullName)) {
            EMPLOYEES.get(fullName).setDepartment(department);
            return true;
        } else {
            return false;
        }
    }

    public void indexSalaries(double rate) {
        double factor = rate / 100;
        for (Employee value : EMPLOYEES.values()) {
            if (value != null) {
                value.setSalary((1 + factor) * value.getSalary());
            }
        }
    }

    public void indexSalaries(double rate, int departmentID) {
        this.filterByDepartment(departmentID).indexSalaries(rate);
    }

    public void indexSalaries(double rate, Department department) {
        this.filterByDepartment(department).indexSalaries(rate);
    }

    private EmployeeBook filterByDepartment(int departmentID) {
        return new EmployeeBook(EMPLOYEES.values().stream().filter(x -> (x != null) && (x.getDepartmentID() == departmentID)).toArray(Employee[]::new));
    }

    private EmployeeBook filterByDepartment(Department department) {
        return new EmployeeBook(EMPLOYEES.values().stream().filter(x -> (x != null) && (x.getDepartment().equals(department))).toArray(Employee[]::new));
    }

    public double sumSalaries() {
        double result = 0;
        for (Employee value : EMPLOYEES.values()) {
            result += value.getSalary();
        }
        return result;
    }

    public double sumSalaries(int departmentID) {
        return this.filterByDepartment(departmentID).sumSalaries();
    }

    public double sumSalaries(Department department) {
        return this.filterByDepartment(department).sumSalaries();
    }

    public double getAverageSalary() {
        if (EMPLOYEES.size() == 0)
            return 0;
        else
            return this.sumSalaries() / EMPLOYEES.size();
    }

    public double getAverageSalary(int departmentID) {
        return this.filterByDepartment(departmentID).getAverageSalary();
    }

    public double getAverageSalary(Department department) {
        return this.filterByDepartment(department).getAverageSalary();
    }

    public Employee findEmployeeWithMinSalary() {
        if (EMPLOYEES.size() > 0) {
            return EMPLOYEES.values().stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
        }
        else
            return null;
    }

    public Employee findEmployeeWithMinSalary(int departmentID) {
        return this.filterByDepartment(departmentID).findEmployeeWithMinSalary();
    }

    public Employee findEmployeeWithMinSalary(Department department) {
        return this.filterByDepartment(department).findEmployeeWithMinSalary();
    }

    public Employee findEmployeeWithMaxSalary() {
        if (EMPLOYEES.size() > 0) {
            return EMPLOYEES.values().stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        }
        else
            return null;
    }

    public Employee findEmployeeWithMaxSalary(int departmentID) {
        return this.filterByDepartment(departmentID).findEmployeeWithMaxSalary();
    }

    public Employee findEmployeeWithMaxSalary(Department department) {
        return this.filterByDepartment(department).findEmployeeWithMaxSalary();
    }

    public void findEmployeesWithSalaryLessThan(double threshold) {
        for (Employee employee : EMPLOYEES.values()) {
            if ((employee != null) && (employee.getSalary() < threshold))
                System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public void findEmployeesWithSalaryMoreThan(double threshold) {
        for (Employee employee : EMPLOYEES.values()) {
            if ((employee != null) && (employee.getSalary() >= threshold))
                System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public void printArray() {
        for (Employee employee : EMPLOYEES.values()) {
            if (employee != null)
                System.out.println(employee);
        }
    }

    public void printArray(int departmentID) {
        for (Employee employee : this.filterByDepartment(departmentID).EMPLOYEES.values())
            System.out.println(employee.toStringWithoutDepartment());
    }

    public void printArray(Department department) {
        for (Employee employee : this.filterByDepartment(department).EMPLOYEES.values())
            System.out.println(employee.toStringWithoutDepartment());
    }

    public void printNames() {
        for (Employee employee : EMPLOYEES.values()) {
            if (employee != null)
                System.out.println(employee.getFullName());
        }
    }

    public void printNames(int departmentID) {
        this.filterByDepartment(departmentID).printNames();
    }

    public void printNames(Department department) {
        this.filterByDepartment(department).printNames();
    }

    public void printArrayCategorizedByDepartmentID() {
        for (int i = 1; i <= Department.values().length; i++) {
            System.out.printf("Список сотрудников отдела №%d:\n", i);
            this.printNames(i);
            System.out.println("--");
        }
    }
}
