package pro.sky.course2.hw15.animals;

import pro.sky.course2.hw15.Animal;
import pro.sky.course2.hw15.Utility;

import java.util.Objects;

public class Mammal extends Animal {
    public enum Nutrition {
        HERBIVORE("травоядное"),
        CARNIVOROUS("плотоядное"),
        OMNIVORE("всеядное");

        private final String VALUE;

        Nutrition(String VALUE) {
            this.VALUE = VALUE;
        }

        @Override
        public String toString() {
            return VALUE;
        }
    }

    private static final Double DEFAULT_SPEED = 0.0;
    private static final Nutrition DEFAULT_NUTRITION = Nutrition.OMNIVORE;

    private Double speed;
    private final Nutrition NUTRITION;

    public Mammal(String KIND_OF_ANIMAL, String NAME, Integer AGE, String HABITAT, Double speed, Nutrition NUTRITION) {
        super(KIND_OF_ANIMAL, NAME, AGE, HABITAT);
        setSpeed(speed);
        this.NUTRITION = NUTRITION != null ? NUTRITION : DEFAULT_NUTRITION;
    }

    public Double getSpeed() {
        return speed;
    }

    public Nutrition getNUTRITION() {
        return NUTRITION;
    }

    public void setSpeed(Double speed) {
        this.speed = Utility.isNumberNotNullOrNegative(speed) ? speed : DEFAULT_SPEED;
    }

    @Override
    public void eat() {
        switch(NUTRITION) {
            case HERBIVORE:
                System.out.printf("%s жует свежую травку.\n",
                        getKIND_OF_ANIMAL_AND_NAME());
                break;
            case CARNIVOROUS:
                System.out.printf("%s впивается клыками в бренное тело антилопы.\n",
                        getKIND_OF_ANIMAL_AND_NAME());
                break;
            case OMNIVORE:
                System.out.printf("%s уплетает свою порцию котлет с пюрешкой в гордом одиночестве – посетители кафе почему-то резко решили покинуть заведение.\n",
                        getKIND_OF_ANIMAL_AND_NAME());
        }
    }

    @Override
    public void move() {
        switch(NUTRITION) {
            case HERBIVORE:
                System.out.printf("%s обратил(а) внимание на поле полное свежей сочной травы и отправился(-ась) утолить свой голод.\n",
                        getKIND_OF_ANIMAL_AND_NAME());
                break;
            case CARNIVOROUS:
                System.out.printf("%s заметил(а) недалеко от себя пасущуюся антилопу и с этого момента невинная бедняжка антилопа обречена.\n",
                        getKIND_OF_ANIMAL_AND_NAME());
                break;
            case OMNIVORE:
                System.out.printf("%s никак не мог(ла) решить чем бы ему(ей) отобедать сегодня. Поэтому он(а) решил(а) посетить ближайшее кафе и заказать там пюрешку с котлетой.\n",
                        getKIND_OF_ANIMAL_AND_NAME());
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n[Млекопитающее] %s\nСкорость передвижения: %.2f км/ч\nТип питания: %s\n%s",
                Utility.DELIMITER, super.toString(), speed, NUTRITION, Utility.DELIMITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mammal mammal = (Mammal) o;
        return speed.equals(mammal.speed) && NUTRITION == mammal.NUTRITION;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed, NUTRITION);
    }
}
