package sky.pro.java.course2.hw13;

public class Hufflepuff extends Hogwarts{
    private final int INDUSTRIOUSNESS;
    private final int LOYALTY;
    private final int HONESTY;

    public Hufflepuff(String name, int wizardry, int transgressionDistance, int industriousness, int loyalty, int honesty) {
        super(name, wizardry, transgressionDistance);
        INDUSTRIOUSNESS = industriousness;
        LOYALTY = loyalty;
        HONESTY = honesty;
    }

    @Override
    public String toString() {
        return String.format("%sТрудолюбивость: %d/100\nВерность: %d/100\nЧестность: %d/100\n----------\n", super.toString(), INDUSTRIOUSNESS, LOYALTY, HONESTY);
    }

    int getSumOfLocalQualities() {
        return INDUSTRIOUSNESS + LOYALTY + HONESTY;
    }

    String getFacultyBelonging() {
        return "пуффендуец";
    }
}
