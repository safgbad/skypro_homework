package sky.pro.java.course1.hw9;

public class Main {
    public static void main(String[] args) {
        // Task 1
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.printf("ФИО сотрудника — %s\n", fullName);

        // Task 2
        System.out.printf("Данные ФИО сотрудника для заполнения отчета — %s\n", fullName.toUpperCase());

        // Task 3
        fullName = "Иванов Семён Семёнович";
        System.out.printf("Данные ФИО сотрудника — %s\n", fullName.replaceAll("ё", "е"));

        /* Используя класс Employee:
        Employee employee = new Employee("Семён", "Семёнович", "Иванов");
        System.out.printf("ФИО сотрудника — %s\n", employee.getFullName());
        System.out.printf("Данные ФИО сотрудника для заполнения отчета — %s\n", employee.getFullNameForReport());
         */
    }
}
