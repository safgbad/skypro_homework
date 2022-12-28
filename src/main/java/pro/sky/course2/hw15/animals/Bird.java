package pro.sky.course2.hw15.animals;

import pro.sky.course2.hw15.Animal;
import pro.sky.course2.hw15.Utility;

import java.util.Objects;

public class Bird extends Animal {
    private static final Boolean DEFAULT_IS_FLYING = true;

    private final Boolean IS_FLYING;

    public Bird(String KIND_OF_ANIMAL, String NAME, Integer AGE, String HABITAT, Boolean IS_FLYING) {
        super(KIND_OF_ANIMAL, NAME, AGE, HABITAT);
        this.IS_FLYING = IS_FLYING != null ? IS_FLYING : DEFAULT_IS_FLYING;
    }

    public Boolean getIS_FLYING() {
        return IS_FLYING;
    }

    @Override
    public void eat() {
        if (IS_FLYING) {
            System.out.printf("%s в один присест проглатывает здоровенного карпа.\n", getKIND_OF_ANIMAL_AND_NAME());
        } else {
            System.out.printf("%s клюет опавшие зерна пшеницы.\n", getKIND_OF_ANIMAL_AND_NAME());
        }
    }

    @Override
    public void move() {
        if (IS_FLYING) {
            System.out.printf("%s в поисках жертвы рассекает воздушное пространство над небольшим водоемом.\n", getKIND_OF_ANIMAL_AND_NAME());
        } else {
            System.out.printf("Рожденный ползать летать не может. %s ходит по полю, принадлежащему местному аграрию Василию, в поисках зерна.\n", getKIND_OF_ANIMAL_AND_NAME());
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n[Птица] %s\nУмеет летать: %s\n%s",
                Utility.DELIMITER, super.toString(), IS_FLYING ? "да" : "нет", Utility.DELIMITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return IS_FLYING.equals(bird.IS_FLYING);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), IS_FLYING);
    }
}
