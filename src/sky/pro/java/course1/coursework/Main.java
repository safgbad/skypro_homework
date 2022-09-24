package sky.pro.java.course1.coursework;

public class Main {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[] {new Employee("Иванов Иван Иванович", 4, 25743.21),
                new Employee("Александров Александр Александрович", 1, 37293.53),
                new Employee("Петров Петр Петрович", 4, 21482.48),
                new Employee("Сергеев Сергей Сергеевич", 2, 35294.28),
                new Employee("Васильев Василий Васильевич", 3, 41304.67),
                new Employee("Дмитриев Дмитрий Дмитриевич", 2, 27450.11),
                new Employee("Владимиров Владимир Владимирович", 5, 39320.93),
                new Employee("Анатольев Анатолий Анатольевич", 5, 26394.75),
                new Employee("Викторов Виктор Викторович", 1, 45384.86),
                new Employee("Витальев Виталий Витальевич", 2, 33957.56)};
        System.out.println("Список всех сотрудников:");
        Employee.printArray(employees);
        System.out.println("--");
        System.out.printf("Общие затраты на заработную плату сотрудников: %.2f рублей\n", Employee.sumSalaries(employees));
        System.out.println("--");
        System.out.println("Работник с наименьшей зарплатой:");
        System.out.println(Employee.findEmployeeWithMinSalary(employees));
        System.out.println("--");
        System.out.println("Работник с наибольшей зарплатой:");
        System.out.println(Employee.findEmployeeWithMaxSalary(employees));
        System.out.println("--");
        System.out.printf("Средняя зарплата сотрудников составляет %.2f рублей\n", Employee.getAverageSalary(employees));
        System.out.println("--");
        System.out.println("Список имен сотрудников:");
        Employee.printNames(employees);
        System.out.println("--");
        int departmentID = 2;
        Employee.indexSalaries(employees, -15, departmentID);
        System.out.printf("Список сотрудников отдела №%d:\n", departmentID);
        Employee.printArray(employees, departmentID);
        System.out.println("--");
        System.out.printf("Сотрудник с минимальной зарплатой в отделе №%d:\n", departmentID);
        System.out.println(Employee.findEmployeeWithMinSalary(employees, departmentID).toStringWithoutDepartment());
        System.out.println("--");
        System.out.printf("Сотрудник с максимальной зарплатой в отделе №%d:\n", departmentID);
        System.out.println(Employee.findEmployeeWithMaxSalary(employees, departmentID).toStringWithoutDepartment());
        System.out.println("--");
        System.out.printf("Общие затраты на заработную плату сотрудников в отделе №%d: %.2f рублей\n", departmentID, Employee.sumSalaries(employees, departmentID));
        System.out.println("--");
        System.out.printf("Средняя зарплата сотрудников в отделе №%d составляет %.2f рублей\n", departmentID, Employee.getAverageSalary(employees, departmentID));
        System.out.println("--");
        System.out.println("Список всех сотрудников:");
        Employee.printArray(employees);
        System.out.println("--");
        double threshold = 27000;
        System.out.printf("Сотрудники с зарплатой меньшей %.2f рублей:\n", threshold);
        Employee.findEmployeesWithSalaryLessThan(employees, threshold);
        System.out.println("--");
        System.out.printf("Сотрудники с зарплатой большей или равной %.2f рублей:\n", threshold);
        Employee.findEmployeesWithSalaryMoreThan(employees, threshold);
    }
}
