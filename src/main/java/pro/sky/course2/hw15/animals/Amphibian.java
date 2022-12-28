package pro.sky.course2.hw15.animals;

import pro.sky.course2.hw15.Animal;
import pro.sky.course2.hw15.Utility;

public class Amphibian extends Animal {
    public Amphibian(String KIND_OF_ANIMAL, String NAME, Integer AGE, String HABITAT) {
        super(KIND_OF_ANIMAL, NAME, AGE, HABITAT);
    }

    @Override
    public void eat() {
        System.out.printf("%s лакомится крайне аппетитными мухами.\n", getKIND_OF_ANIMAL_AND_NAME());
    }

    @Override
    public void move() {
        System.out.printf("%s приметил(а) скопище аппетитных мясистых мух и отправился(-ась) на охоту.\n", getKIND_OF_ANIMAL());
    }

    @Override
    public String toString() {
        return String.format("%s\n[Земноводное] %s\n%s",
                Utility.DELIMITER, super.toString(), Utility.DELIMITER);
    }
}
