package sky.pro.java.course2.hw13;

public class Gryffindor extends Hogwarts {
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

    private int getSumOfLocalQualities() {
        return NOBILITY + HONOUR + BRAVERY;
    }

    public static void compareLocalQualities(Gryffindor pupil1, Gryffindor pupil2) {
        int sum1 = pupil1.getSumOfLocalQualities();
        int sum2 = pupil2.getSumOfLocalQualities();
        String name1 = pupil1.getName();
        String name2 = pupil2.getName();
        if (sum1 == sum2) {
            System.out.printf("%s и %s наравне как ученики одного факультета\n", name1, name2);
        } else {
            String winner, loser;
            if (sum1 < sum2) {
                winner = name2;
                loser = name1;
            } else {
                winner = name1;
                loser = name2;
            }
            System.out.printf("%s лучший гриффиндорец чем %s\n", winner, loser);
        }
    }
}
