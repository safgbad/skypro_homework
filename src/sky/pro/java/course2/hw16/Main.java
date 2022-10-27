package sky.pro.java.course2.hw16;

public class Main {
    public static void main(String[] args) {
        String login = "_ivanIvanov2022";
        String password = "qwerty123456";
        String confirmPassword = "qwerty1234567";
        System.out.println(check(login, password, confirmPassword));
    }

    public static boolean check(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void checkLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Превышена максимально допустимая длина логина");
        }
        if (checkStringForIllegalCharacters(login)) {
            throw new WrongLoginException("В логине присутствуют недопустимые символы");
        }
    }

    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() > 20) {
            throw new WrongPasswordException("Превышена максимально допустимая длина пароля");
        }
        if (checkStringForIllegalCharacters(password)) {
            throw new WrongPasswordException("В пароле присутствуют недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static boolean checkStringForIllegalCharacters(String str) {
        for (char c : str.toCharArray()) {
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !Character.isDigit(c) && c != '_') {
                return true;
            }
        }
        return false;
    }
}
