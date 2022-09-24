package sky.pro.java.course1.coursework;

public class Main {
    private static EmployeeBook employees;

    public static void main(String[] args) {
        employees = new EmployeeBook(new Employee[] {new Employee("Иванов Иван Иванович", 4, 25743.21),
                new Employee("Александров Александр Александрович", 1, 37293.53),
                new Employee("Петров Петр Петрович", 4, 21482.48),
                new Employee("Сергеев Сергей Сергеевич", 2, 35294.28),
                new Employee("Васильев Василий Васильевич", 3, 41304.67),
                new Employee("Дмитриев Дмитрий Дмитриевич", 2, 27450.11),
                new Employee("Владимиров Владимир Владимирович", 5, 39320.93),
                new Employee("Анатольев Анатолий Анатольевич", 5, 26394.75),
                new Employee("Викторов Виктор Викторович", 1, 45384.86),
                new Employee("Витальев Виталий Витальевич", 2, 33957.56)});
        System.out.println("Список всех сотрудников:");
        employees.printArray();
        System.out.println("--");
        System.out.printf("Общие затраты на заработную плату сотрудников: %.2f рублей\n", employees.sumSalaries());
        System.out.println("--");
        System.out.println("Работник с наименьшей зарплатой:");
        System.out.println(employees.findEmployeeWithMinSalary());
        System.out.println("--");
        System.out.println("Работник с наибольшей зарплатой:");
        System.out.println(employees.findEmployeeWithMaxSalary());
        System.out.println("--");
        System.out.printf("Средняя зарплата сотрудников составляет %.2f рублей\n", employees.getAverageSalary());
        System.out.println("--");
        System.out.println("Список имен сотрудников:");
        employees.printNames();
        System.out.println("--");
        int departmentID = 2;
        employees.indexSalaries(-15, departmentID);
        System.out.printf("Список сотрудников отдела №%d:\n", departmentID);
        employees.printArray(departmentID);
        System.out.println("--");
        System.out.printf("Сотрудник с минимальной зарплатой в отделе №%d:\n", departmentID);
        System.out.println(employees.findEmployeeWithMinSalary(departmentID).toStringWithoutDepartment());
        System.out.println("--");
        System.out.printf("Сотрудник с максимальной зарплатой в отделе №%d:\n", departmentID);
        System.out.println(employees.findEmployeeWithMaxSalary(departmentID).toStringWithoutDepartment());
        System.out.println("--");
        System.out.printf("Общие затраты на заработную плату сотрудников в отделе №%d: %.2f рублей\n", departmentID, employees.sumSalaries(departmentID));
        System.out.println("--");
        System.out.printf("Средняя зарплата сотрудников в отделе №%d составляет %.2f рублей\n", departmentID, employees.getAverageSalary(departmentID));
        System.out.println("--");
        System.out.println("Список всех сотрудников:");
        employees.printArray();
        System.out.println("--");
        double threshold = 27000;
        System.out.printf("Сотрудники с зарплатой меньшей %.2f рублей:\n", threshold);
        employees.findEmployeesWithSalaryLessThan(threshold);
        System.out.println("--");
        System.out.printf("Сотрудники с зарплатой большей или равной %.2f рублей:\n", threshold);
        employees.findEmployeesWithSalaryMoreThan(threshold);
        System.out.println("--");
        System.out.println("Список сотрудников после удаления:");
        if (employees.deleteEmployee("Петров Петр Петрович") &&
                employees.deleteEmployee(5) &&
                employees.deleteEmployee(7, "Анатольев Анатолий Анатольевич")) {
            employees.printArray();
        }
        System.out.println("--");
        System.out.println("Список сотрудников после добавления:");
        if (employees.addEmployee("Максимов Максим Максимович", 4, 28574.59) &&
                employees.addEmployee("Константинов Константин Константинович", 1, 37234.38)) {
            employees.printArray();
        }
        System.out.println("--");
        System.out.println("Переместим Максимова Максима Максимовича в другой отдел и повысим ему зарплату:");
        if (employees.setSalary("Максимов Максим Максимович", 30000.00) &&
                employees.setDepartmentID("Максимов Максим Максимович", 2)) {
            employees.printArray();
        }
        employees.printArrayCategorizedByDepartmentID();
    }
}
