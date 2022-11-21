package sky.pro.java.course2.hw13;

public class Human {
    private static final String NOT_SPECIFIED = "Информация не указана";

    private int yearOfBirth = 0;
    private String name = NOT_SPECIFIED;
    private String town = NOT_SPECIFIED;
    private String jobTitle = NOT_SPECIFIED;

    public Human(int yearOfBirth, String name, String town) {
        this.yearOfBirth = Math.max(yearOfBirth, this.yearOfBirth);
        if (!isNullOrBlank(name)) this.name = name;
        if (!isNullOrBlank(town)) this.town = town;
    }

    public Human(int yearOfBirth, String name, String town, String jobTitle) {
        this(yearOfBirth, name, town);
        this.jobTitle = jobTitle;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getTown() {
        return town;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = Math.max(yearOfBirth, this.yearOfBirth);
    }

    public void setTown(String town) {
        if (!isNullOrBlank(town)) this.town = town;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Привет!");
        if (name != NOT_SPECIFIED) stringBuilder.append(" Меня зовут ").append(name).append(".");
        if (town != NOT_SPECIFIED) stringBuilder.append(" Я из города ").append(town).append(".");
        stringBuilder.append(" Я родился в ").append(yearOfBirth).append(" году.");
        if (jobTitle != NOT_SPECIFIED) stringBuilder.append(" Я работаю на должности ").append(jobTitle).append(".");
        stringBuilder.append(" Будем знакомы!");
        return stringBuilder.toString();
    }
}
