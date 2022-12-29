package pro.sky.course2.hw20.passports;

import pro.sky.utility.ValueCheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Pattern;

public class Passport {
    private static final Pattern PASSPORT_ID_PATTERN = Pattern.compile("^\\d{4} \\d{6}$");

    private final String passportID;
    private String secondName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;

    public Passport(String passportID, String secondName, String firstName, String middleName, LocalDate birthDate) {
        if (!checkPassportID(passportID)) {
            throw new IllegalArgumentException("Введен некорректный номер паспорта");
        }
        if (!ValueCheck.isStringNotNullAndNotBlank(secondName)) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        if (!ValueCheck.isStringNotNullAndNotBlank(firstName)) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Дата рождения не может быть пустой");
        }
        this.passportID = passportID;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = ValueCheck.isStringNotNullAndNotBlank(middleName) ? middleName : null;
        this.birthDate = birthDate;
    }

    public Passport(String passportID, String secondName, String firstName, LocalDate birthDate) {
        if (!checkPassportID(passportID)) {
            throw new IllegalArgumentException("Введен некорректный номер паспорта");
        }
        if (!ValueCheck.isStringNotNullAndNotBlank(secondName)) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        if (!ValueCheck.isStringNotNullAndNotBlank(firstName)) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Дата рождения не может быть пустой");
        }
        this.passportID = passportID;
        this.secondName = secondName;
        this.firstName = firstName;
        middleName = null;
        this.birthDate = birthDate;
    }

    public String getPassportID() {
        return passportID;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void updateData(Passport newPassport) {
        this.secondName = newPassport.secondName;
        this.firstName = newPassport.firstName;
        this.middleName = newPassport.middleName;
        this.birthDate = newPassport.birthDate;
    }

    private static boolean checkPassportID(String passportID) {
        if (!ValueCheck.isStringNotNullAndNotBlank(passportID)) {
            return false;
        }
        return PASSPORT_ID_PATTERN.matcher(passportID.trim()).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return passportID.equals(passport.passportID) && secondName.equals(passport.secondName) && firstName.equals(passport.firstName) && Objects.equals(middleName, passport.middleName) && birthDate.equals(passport.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportID, secondName, firstName, middleName, birthDate);
    }

    @Override
    public String toString() {
        return String.format("%s %s%s, паспорт № %s, дата рождения: %s",
                secondName,
                firstName,
                middleName != null ? " " + middleName : "",
                passportID,
                birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
