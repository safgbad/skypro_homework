package pro.sky.course2.hw13;

public class Human {
    private static final String NOT_SPECIFIED = "Информация не указана";
    private static final Integer DEFAULT_YEAR_OF_BIRTH = 1984;

    private Integer yearOfBirth;
    private final String NAME;
    private String town;
    private String jobTitle;

    public Human(Integer yearOfBirth, String name, String town) {
        setYearOfBirth(yearOfBirth);
        this.NAME = Utility.isStringNotNullOrBlank(name) ? name : NOT_SPECIFIED;
        setTown(town);
        jobTitle = NOT_SPECIFIED;
    }

    public Human(int yearOfBirth, String name, String town, String jobTitle) {
        this(yearOfBirth, name, town);
        setJobTitle(jobTitle);
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getNAME() {
        return NAME;
    }

    public String getTown() {
        return town;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = Utility.isNumberNotNullOrNegative(yearOfBirth) ? yearOfBirth : DEFAULT_YEAR_OF_BIRTH;
    }

    public void setTown(String town) {
        this.town = Utility.isStringNotNullOrBlank(town) ? town : NOT_SPECIFIED;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = Utility.isStringNotNullOrBlank(jobTitle) ? jobTitle : NOT_SPECIFIED;
    }

    @Override
    public String toString() {
        return "Привет!" + " Меня зовут " + NAME + "." +
                " Я из города " + town + "." +
                " Я родился в " + yearOfBirth + " году." +
                " Я работаю на должности " + jobTitle + "." +
                " Будем знакомы!";
    }
}
