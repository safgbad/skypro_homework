package sky.pro.java.course2.hw13;

public class Hufflepuff extends Hogwarts {
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

    private int getSumOfLocalQualities() {
        return INDUSTRIOUSNESS + LOYALTY + HONESTY;
    }

    public static void compareLocalQualities(Hufflepuff pupil1, Hufflepuff pupil2) {
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
            System.out.printf("%s лучший пуффендуец чем %s\n", winner, loser);
        }
    }
}
