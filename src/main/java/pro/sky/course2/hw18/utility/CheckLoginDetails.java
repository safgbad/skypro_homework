package pro.sky.course2.hw18.utility;

import pro.sky.course2.hw18.exceptions.WrongLoginException;
import pro.sky.course2.hw18.exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class CheckLoginDetails {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9_]{1,20}$");

    private static boolean checkString(String str) {
        return str != null && PATTERN.matcher(str).matches();
    }

    public static void check(String login, String password, String password_repeat)
            throws WrongLoginException, WrongPasswordException {
        if (!checkString(login)) {
            throw new WrongLoginException();
        }
        if (!checkString(password) || !password.equals(password_repeat)) {
            throw new WrongPasswordException();
        }
    }
}
