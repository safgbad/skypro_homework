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

    private EmployeeBook filterByDepartment(Department department) {
        return new EmployeeBook(Arrays.stream(employees).filter(x -> (x != null) && (x.getDepartment() == department)).toArray(Employee[]::new));
    }

    public void printArray() {
        for (Employee employee : employees) {
            if (employee != null)
                System.out.println(employee);
        }
    }

    public void printArray(int departmentID) {
        for (Employee employee : this.filterByDepartment(departmentID).employees)
            System.out.println(employee.toStringWithoutDepartment());
    }

    public void printArray(Department department) {
        for (Employee employee : this.filterByDepartment(department).employees)
            System.out.println(employee.toStringWithoutDepartment());
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

    public double sumSalaries() {
        double result = 0;
        for (Employee employee : employees) {
            if (employee != null)
                result += employee.getSalary();
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
        if (numberOfEmployees == 0)
            return 0;
        else
            return this.sumSalaries() / numberOfEmployees;
    }

    public double getAverageSalary(int departmentID) {
        return this.filterByDepartment(departmentID).getAverageSalary();
    }

    public double getAverageSalary(Department department) {
        return this.filterByDepartment(department).getAverageSalary();
    }

    public Employee findEmployeeWithMinSalary() {
        if (numberOfEmployees > 0) {
            Employee result = new Employee(Double.POSITIVE_INFINITY);
            for (Employee employee : employees) {
                if ((employee != null) && (result.getSalary() > employee.getSalary()))
                    result = employee;
            }
            return result;
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
        if (numberOfEmployees > 0) {
            Employee result = new Employee(Double.NEGATIVE_INFINITY);
            for (Employee employee : employees) {
                if ((employee != null) && (result.getSalary() < employee.getSalary()))
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

    public Employee findEmployeeWithMaxSalary(Department department) {
        return this.filterByDepartment(department).findEmployeeWithMaxSalary();
    }

    public void findEmployeesWithSalaryLessThan(double threshold) {
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() < threshold))
                System.out.println(employee.toStringWithoutDepartment());
        }
    }

    public void findEmployeesWithSalaryMoreThan(double threshold) {
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() >= threshold))
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

    public boolean addEmployee(String fullName, Department department, double salary) {
        return addEmployee(fullName, department.getDepartmentID(), salary);
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

    public boolean setDepartment(String fullName, int departmentID) {
        try {
            employees[getIndex(fullName)].setDepartmentID(departmentID);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean setDepartment(String fullName, Department department) {
        try {
            employees[getIndex(fullName)].setDepartment(department);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public void indexSalaries(double rate) {
        double factor = rate / 100;
        for (Employee employee : employees) {
            if (employee != null) {
                double employeeSalary = employee.getSalary();
                employee.setSalary(employeeSalary + factor * employeeSalary);
            }
        }
    }

    public void indexSalaries(double rate, int departmentID) {
        this.filterByDepartment(departmentID).indexSalaries(rate);
    }

    public void indexSalaries(double rate, Department department) {
        this.filterByDepartment(department).indexSalaries(rate);
    }
}
