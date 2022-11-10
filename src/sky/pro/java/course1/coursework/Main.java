package sky.pro.java.course1.coursework;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employees = new EmployeeBook(new Employee[] {new Employee("Иванов Иван Иванович", Department.FORTH_DEPARTMENT, 25743.21),
                new Employee("Александров Александр Александрович", Department.FIRST_DEPARTMENT, 37293.53),
                new Employee("Петров Петр Петрович", Department.FORTH_DEPARTMENT, 21482.48),
                new Employee("Сергеев Сергей Сергеевич", Department.SECOND_DEPARTMENT, 35294.28),
                new Employee("Васильев Василий Васильевич", Department.THIRD_DEPARTMENT, 41304.67),
                new Employee("Дмитриев Дмитрий Дмитриевич", Department.SECOND_DEPARTMENT, 27450.11),
                new Employee("Владимиров Владимир Владимирович", Department.FIFTH_DEPARTMENT, 39320.93),
                new Employee("Анатольев Анатолий Анатольевич", Department.FIFTH_DEPARTMENT, 26394.75),
                new Employee("Викторов Виктор Викторович", Department.FIRST_DEPARTMENT, 45384.86),
                new Employee("Витальев Виталий Витальевич", Department.SECOND_DEPARTMENT, 33957.56)});
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
        Department department = Department.SECOND_DEPARTMENT;
        employees.indexSalaries(-15, department);
        System.out.printf("Список сотрудников отдела №%d:\n", department.getDepartmentID());
        employees.printArray(department);
        System.out.println("--");
        System.out.printf("Сотрудник с минимальной зарплатой в отделе №%d:\n", department.getDepartmentID());
        System.out.println(employees.findEmployeeWithMinSalary(department).toStringWithoutDepartment());
        System.out.println("--");
        System.out.printf("Сотрудник с максимальной зарплатой в отделе №%d:\n", department.getDepartmentID());
        System.out.println(employees.findEmployeeWithMaxSalary(department).toStringWithoutDepartment());
        System.out.println("--");
        System.out.printf("Общие затраты на заработную плату сотрудников в отделе №%d: %.2f рублей\n", department.getDepartmentID(), employees.sumSalaries(department));
        System.out.println("--");
        System.out.printf("Средняя зарплата сотрудников в отделе №%d составляет %.2f рублей\n", department.getDepartmentID(), employees.getAverageSalary(department));
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
        employees.addEmployee("Максимов Максим Максимович", Department.FORTH_DEPARTMENT, 28574.59);
        employees.addEmployee("Константинов Константин Константинович", Department.FIRST_DEPARTMENT, 37234.38);
        employees.printArray();
        System.out.println("--");
        System.out.println("Переместим Максимова Максима Максимовича в другой отдел и повысим ему зарплату:");
        if (employees.setSalary("Максимов Максим Максимович", 30000.00) &&
                employees.setDepartment("Максимов Максим Максимович", Department.SECOND_DEPARTMENT)) {
            employees.printArray();
        }
        System.out.println("--");
        employees.printArrayCategorizedByDepartmentID();
    }
}
