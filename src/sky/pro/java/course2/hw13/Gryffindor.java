package sky.pro.java.course2.hw13;

public class Gryffindor extends Hogwarts{
    private final int NOBILITY;
    private final int HONOUR;
    private final int BRAVERY;

    public Gryffindor(String name, int wizardry, int transgressionDistance, int nobility, int honour, int bravery) {
        super(name, wizardry, transgressionDistance);
        NOBILITY = nobility;
        HONOUR = honour;
        BRAVERY = bravery;
    }

    @Override
    public String toString() {
        return String.format("%sБлагородство: %d/100\nЧесть: %d/100\nХрабрость: %d/100\n----------\n", super.toString(), NOBILITY, HONOUR, BRAVERY);
    }

    int getSumOfLocalQualities() {
        return NOBILITY + HONOUR + BRAVERY;
    }

    String getFacultyBelonging() {
        return "гриффиндорец";
    }
}
