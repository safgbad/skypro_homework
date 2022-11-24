package sky.pro.java.course2.hw16;

import sky.pro.java.course2.hw16.utility.InputCheck;

public class Driver {
    private static final String DELIMITER = "----------";
    private static final String DEFAULT_FULL_NAME = "undefined";
    private static final Boolean DEFAULT_DOES_HAVE_DRIVING_LICENSE = false;
    private static final Integer DEFAULT_EXPERIENCE = 0;

    private final String fullName;
    private final Transport vehicle;
    private Boolean doesHaveDrivingLicense;
    private Integer experience;

    public Driver(String fullName, Transport vehicle, Boolean doesHaveDrivingLicense, Integer experience) {
        this.fullName = InputCheck.isStringNotNullAndNotBlank(fullName) ? fullName : DEFAULT_FULL_NAME;
        this.vehicle = vehicle;
        setDoesHaveDrivingLicense(doesHaveDrivingLicense);
        setExperience(experience);
    }

    public String getFullName() {
        return fullName;
    }

    public Transport getVehicle() {
        return vehicle;
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
        this.experience = InputCheck.isNumberNotNullAndNotNegative(experience) ? experience : DEFAULT_EXPERIENCE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DELIMITER).append('\n');
        stringBuilder.append("Водитель: ").append(fullName).append('\n');
        stringBuilder.append(vehicle).append('\n');
        stringBuilder.append("Стаж: ").append(experience).append(" лет\n");
        stringBuilder.append("Наличие водительских прав: ");
        if (doesHaveDrivingLicense) {
            stringBuilder.append("есть").append('\n');
            stringBuilder.append("Допускается к участию");
        } else {
            stringBuilder.append("нет").append('\n');
            stringBuilder.append("Не допускается к участию");
        }
        stringBuilder.append('\n').append(DELIMITER);
        return stringBuilder.toString();
    }
}
