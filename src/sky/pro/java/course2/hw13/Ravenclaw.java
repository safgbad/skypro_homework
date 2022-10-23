package sky.pro.java.course2.hw13;

public class Ravenclaw extends Hogwarts {
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

    private int getSumOfLocalQualities() {
        return INTELLECT + WISDOM + WIT + CREATION;
    }

    public static void compareLocalQualities(Ravenclaw pupil1, Ravenclaw pupil2) {
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
            System.out.printf("%s лучший когтевранец чем %s\n", winner, loser);
        }
    }
}
