package sky.pro.java.course2.hw13;

abstract class Hogwarts {
    private final String NAME;
    private final int WIZARDRY;
    private final int TRANSGRESSION_DISTANCE;

    public Hogwarts(String name, int wizardry, int transgressionDistance) {
        NAME = name;
        WIZARDRY = wizardry;
        TRANSGRESSION_DISTANCE = transgressionDistance;
    }

    @Override
    public String toString() {
        return String.format("%s\n----------\nМощность колдовства: %d/100\nРасстояние трансгрессии: %d/100\n", NAME, WIZARDRY, TRANSGRESSION_DISTANCE);
    }

    private int getSumOfBasicQualities() {
        return WIZARDRY + TRANSGRESSION_DISTANCE;
    }

    public static void compareBasicQualities(Hogwarts pupil1, Hogwarts pupil2) {
        int sum1 = pupil1.getSumOfBasicQualities();
        int sum2 = pupil2.getSumOfBasicQualities();
        if (sum1 == sum2) {
            System.out.printf("%s и %s наравне по сумме основных качеств ученика Хогвартса\n", pupil1.NAME, pupil2.NAME);
        } else {
            String winner, loser;
            if (sum1 < sum2) {
                winner = pupil2.NAME;
                loser = pupil1.NAME;
            } else {
                winner = pupil1.NAME;
                loser = pupil2.NAME;
            }
            System.out.printf("%s лучше по сумме основных качеств ученика Хогвартса чем %s\n", winner, loser);
        }
    }

    abstract int getSumOfLocalQualities();
    abstract String getFacultyBelonging();

    public static void compareLocalQualities(Hogwarts pupil1, Hogwarts pupil2) {
        if (!pupil1.getClass().equals(pupil2.getClass())) {
            throw new IllegalArgumentException("Для сравнения ученики должны быть с одного факультета");
        } else {
            int sum1 = pupil1.getSumOfLocalQualities();
            int sum2 = pupil2.getSumOfLocalQualities();
            if (sum1 == sum2) {
                System.out.printf("%s и %s наравне как ученики одного факультета\n", pupil1.NAME, pupil2.NAME);
            } else {
                String winner, loser;
                if (sum1 < sum2) {
                    winner = pupil2.NAME;
                    loser = pupil1.NAME;
                } else {
                    winner = pupil1.NAME;
                    loser = pupil2.NAME;
                }
                System.out.printf("%s лучший %s чем %s\n", winner, pupil1.getFacultyBelonging(), loser);
            }
        }
    }
}
