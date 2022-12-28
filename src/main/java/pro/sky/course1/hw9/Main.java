package pro.sky.course1.hw9;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.printf("ФИО сотрудника — %s\n", fullName);
        System.out.println("--");

        // Task 2
        System.out.println("Task 2");
        System.out.printf("Данные ФИО сотрудника для заполнения отчета — %s\n", fullName.toUpperCase());
        System.out.println("--");

        // Task 3
        System.out.println("Task 3");
        fullName = "Иванов Семён Семёнович";
        System.out.printf("Данные ФИО сотрудника — %s\n", fullName.replaceAll("ё", "е"));
        System.out.println("--");

        /* Используя класс Employee:
        Employee employee = new Employee("Семён", "Семёнович", "Иванов");
        System.out.printf("ФИО сотрудника — %s\n", employee.getFullName());
        System.out.printf("Данные ФИО сотрудника для заполнения отчета — %s\n", employee.getFullNameForReport());
         */

        // Task 4
        System.out.println("Task 4");
        fullName = "Ivanov Ivan Ivanovich";
        fullName = fullName.trim();
        int firstSpace = fullName.indexOf(' ');
        lastName = fullName.substring(0, firstSpace);
        int secondSpace = fullName.lastIndexOf(' ');
        firstName = fullName.substring(firstSpace + 1, secondSpace);
        middleName = fullName.substring(secondSpace + 1);
        System.out.printf("Имя сотрудника – %s\n", firstName);
        System.out.printf("Фамилия сотрудника – %s\n", lastName);
        System.out.printf("Отчество сотрудника – %s\n", middleName);
        System.out.println("--");

        // Task 5
        System.out.println("Task 5");
        fullName = "ivanov ivan ivanovich";
        fullName = fullName.trim();
        firstSpace = fullName.indexOf(' ');
        secondSpace = fullName.lastIndexOf(' ');
        char[] fullName_char = fullName.toCharArray();
        fullName_char[0] = Character.toUpperCase(fullName_char[0]);
        fullName_char[firstSpace + 1] = Character.toUpperCase(fullName_char[firstSpace + 1]);
        fullName_char[secondSpace + 1] = Character.toUpperCase(fullName_char[secondSpace + 1]);
        fullName = String.valueOf(fullName_char);
        System.out.printf("Верное написание Ф. И. О. сотрудника с заглавных букв — %s\n", fullName);
        System.out.println("--");

        // Task 6
        System.out.println("Task 6");
        String firstString = "135";
        String secondString = "246";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < firstString.length() * 2; i++)
            stringBuilder.append(i % 2 == 0 ? firstString.charAt(i / 2) : secondString.charAt((i - 1) / 2));
        System.out.printf("Данные строки – %s\n", stringBuilder);
        System.out.println("--");

        // Task 7
        System.out.println("Task 7");
        String string = "aabccddefgghiijjkk";
        stringBuilder = new StringBuilder();
        int pointer = 0;
        while (pointer < string.length()) {
            char character = string.charAt(pointer);
            int lastIndexOfCurrentChar = string.lastIndexOf(character);
            if (pointer != lastIndexOfCurrentChar) {
                stringBuilder.append(character);
                pointer = lastIndexOfCurrentChar + 1;
            } else
                pointer++;
        }
        System.out.println(stringBuilder);
        System.out.println("--");
    }
}
