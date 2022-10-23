package sky.pro.java.course2.hw13;

public class Slytherin extends Hogwarts {
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

    private int getSumOfLocalQualities() {
        return CUNNING + DETERMINATION + AMBITIOUSNESS + RESOURCEFULNESS + LUST_FOR_POWER;
    }

    public static void compareLocalQualities(Slytherin pupil1, Slytherin pupil2) {
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
            System.out.printf("%s лучший слизеринец чем %s\n", winner, loser);
        }
    }
}
