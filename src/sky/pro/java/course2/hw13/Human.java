package sky.pro.java.course2.hw13;

public class Human {
    private static final String NOT_SPECIFIED = "Информация не указана";

    private int yearOfBirth = 0;
    private String name = NOT_SPECIFIED;
    private String town = NOT_SPECIFIED;
    private String jobTitle = NOT_SPECIFIED;

    public Human(int yearOfBirth, String name, String town) {
        this.yearOfBirth = Math.max(yearOfBirth, this.yearOfBirth);
        this.name = Main.checkIfBlankAndReturn(name, this.name);
        this.town = Main.checkIfBlankAndReturn(town, this.town);
    }

    public Human(int yearOfBirth, String name, String town, String jobTitle) {
        this(yearOfBirth, name, town);
        this.jobTitle = jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        if (jobTitle != null && !jobTitle.isBlank()) {
            return String.format("Привет! Меня зовут %s. Я из города %s. Я родился в %d году. Я работаю на должности %s. Будем знакомы!", name, town, yearOfBirth, jobTitle);
        } else {
            return String.format("Привет! Меня зовут %s. Я из города %s. Я родился в %d году. Будем знакомы!", name, town, yearOfBirth);

        }
    }
}
