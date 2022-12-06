package sky.pro.java.course2.hw16.stuff.driver;

import sky.pro.java.utility.ValueCheck;

import java.util.Objects;

public abstract class Driver {
    private static final String DELIMITER = "----------";
    private static final String DEFAULT_FULL_NAME = "undefined";
    private static final Boolean DEFAULT_DOES_HAVE_DRIVING_LICENSE = false;
    private static final Integer DEFAULT_EXPERIENCE = 0;

    private final String fullName;
    private Boolean doesHaveDrivingLicense;
    private Integer experience;

    public Driver(String fullName, Boolean doesHaveDrivingLicense, Integer experience) {
        this.fullName = ValueCheck.isStringNotNullAndNotBlank(fullName) ? fullName : DEFAULT_FULL_NAME;
        setDoesHaveDrivingLicense(doesHaveDrivingLicense);
        setExperience(experience);
    }

    public String getFullName() {
        return fullName;
    }

    public Boolean getDoesHaveDrivingLicense() {
        return doesHaveDrivingLicense;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setDoesHaveDrivingLicense(Boolean doesHaveDrivingLicense) {
        this.doesHaveDrivingLicense = doesHaveDrivingLicense != null ?
                doesHaveDrivingLicense : DEFAULT_DOES_HAVE_DRIVING_LICENSE;
    }

    public void setExperience(Integer experience) {
        this.experience = ValueCheck.isNumberNotNullAndNotNegative(experience) ? experience : DEFAULT_EXPERIENCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return fullName.equals(driver.fullName) && doesHaveDrivingLicense.equals(driver.doesHaveDrivingLicense) && experience.equals(driver.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, doesHaveDrivingLicense, experience);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DELIMITER).append('\n');
        stringBuilder.append("Водитель: ").append(fullName).append('\n');
        stringBuilder.append("Стаж: ").append(experience).append(" лет\n");
        stringBuilder.append("Наличие водительских прав: ");
        if (doesHaveDrivingLicense) {
            stringBuilder.append("есть").append('\n');
        } else {
            stringBuilder.append("нет").append('\n');
        }
        stringBuilder.append(DELIMITER);
        return stringBuilder.toString();
    }
}
