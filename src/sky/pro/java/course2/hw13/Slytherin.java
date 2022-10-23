package sky.pro.java.course2.hw13;

public class Slytherin extends Hogwarts{
    private final int CUNNING;
    private final int DETERMINATION;
    private final int AMBITIOUSNESS;
    private final int RESOURCEFULNESS;
    private final int LUST_FOR_POWER;

    public Slytherin(String name, int wizardry, int transgressionDistance, int cunning, int determination, int ambitiousness, int resourcefulness, int lustForPower) {
        super(name, wizardry, transgressionDistance);
        CUNNING = cunning;
        DETERMINATION = determination;
        AMBITIOUSNESS = ambitiousness;
        RESOURCEFULNESS = resourcefulness;
        LUST_FOR_POWER = lustForPower;
    }

    @Override
    public String toString() {
        return String.format("%sХитрость: %d/100\nРешительность: %d/100\nАмбициозность: %d/100\nНаходчивость: %d/100\nЖажда власти: %d/100\n----------\n", super.toString(), CUNNING, DETERMINATION, AMBITIOUSNESS, RESOURCEFULNESS, LUST_FOR_POWER);
    }

    int getSumOfLocalQualities() {
        return CUNNING + DETERMINATION + AMBITIOUSNESS + RESOURCEFULNESS + LUST_FOR_POWER;
    }

    String getFacultyBelonging() {
        return "слизеринец";
    }
}
