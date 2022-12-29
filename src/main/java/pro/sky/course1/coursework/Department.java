package pro.sky.course1.coursework;

public enum Department {
    FIRST_DEPARTMENT(1),
    SECOND_DEPARTMENT(2),
    THIRD_DEPARTMENT(3),
    FORTH_DEPARTMENT(4),
    FIFTH_DEPARTMENT(5);

    private final int departmentID;

    Department(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public static Department getDepartmentByID(int departmentID) {
        switch (departmentID) {
            case 1:
                return FIRST_DEPARTMENT;
            case 2:
                return SECOND_DEPARTMENT;
            case 3:
                return THIRD_DEPARTMENT;
            case 4:
                return FORTH_DEPARTMENT;
            case 5:
                return FIFTH_DEPARTMENT;
            default:
                return null;
        }
    }
}
