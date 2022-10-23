package sky.pro.java.course2.hw13;

public class Ravenclaw extends Hogwarts{
    private final int INTELLECT;
    private final int WISDOM;
    private final int WIT;
    private final int CREATION;

    public Ravenclaw(String name, int wizardry, int transgressionDistance, int intellect, int wisdom, int wit, int creation) {
        super(name, wizardry, transgressionDistance);
        INTELLECT = intellect;
        WISDOM = wisdom;
        WIT = wit;
        CREATION = creation;
    }

    @Override
    public String toString() {
        return String.format("%sИнтеллект: %d/100\nМудрость: %d/100\nОстроумность: %d/100\nТворчество: %d/100\n----------\n", super.toString(), INTELLECT, WISDOM, WIT, CREATION);
    }

    int getSumOfLocalQualities() {
        return INTELLECT + WISDOM + WIT + CREATION;
    }

    String getFacultyBelonging() {
        return "когтевранец";
    }
}
