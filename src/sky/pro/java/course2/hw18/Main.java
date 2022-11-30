package sky.pro.java.course2.hw18;

import sky.pro.java.course2.hw18.exceptions.*;
import sky.pro.java.course2.hw18.utility.CheckLoginDetails;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isChecked = false;
        Scanner scanner = new Scanner(System.in);
        String login, password, password_repeat;
        while (!isChecked) {
            System.out.println("Введите логин:");
            login = scanner.nextLine();
            System.out.println("Введите пароль:");
            password = scanner.nextLine();
            System.out.println("Повторите пароль:");
            password_repeat = scanner.nextLine();
            try {
                CheckLoginDetails.check(login, password, password_repeat);
                System.out.println("Логин и пароль введены корректно");
                isChecked = true;
            } catch (WrongLoginException e) {
                System.out.println("Логин введен некорректно");
            } catch (WrongPasswordException e) {
                System.out.println("Пароли введены некорректно или не совпадают");
            }
        }
    }
}
