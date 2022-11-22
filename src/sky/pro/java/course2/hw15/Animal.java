package sky.pro.java.course2.hw15;

import java.util.Objects;

public abstract class Animal {
    private static final String DEFAULT_KIND_OF_ANIMAL = "undefined";
    private static final String DEFAULT_NAME = "unnamed";
    private static final Integer DEFAULT_AGE = -1;
    private static final String DEFAULT_HABITAT = "undefined";

    private final String KIND_OF_ANIMAL;
    private final String NAME;
    private Integer age;
    private String habitat;

    public Animal(String KIND_OF_ANIMAL, String NAME, Integer age, String habitat) {
        this.KIND_OF_ANIMAL = Utility.isStringNotNullOrBlank(KIND_OF_ANIMAL) ? KIND_OF_ANIMAL : DEFAULT_KIND_OF_ANIMAL;
        this.NAME = Utility.isStringNotNullOrBlank(NAME) ? NAME : DEFAULT_NAME;
        setAge(age);
        setHabitat(habitat);
    }

    public String getKIND_OF_ANIMAL() {
        return KIND_OF_ANIMAL;
    }

    public String getNAME() {
        return NAME;
    }

    public Integer getAge() {
        return age;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setAge(Integer age) {
        this.age = Utility.isNumberNotNullOrNegative(age) ? age : DEFAULT_AGE;
    }

    public void setHabitat(String habitat) {
        this.habitat = Utility.isStringNotNullOrBlank(habitat) ? habitat : DEFAULT_HABITAT;
    }

    public String getKIND_OF_ANIMAL_AND_NAME() {
        return String.format("%s %s", KIND_OF_ANIMAL, NAME);
    }

    public abstract void eat();

    public void sleep() {
        System.out.printf("%s %s спит.\n", KIND_OF_ANIMAL, NAME);
    }

    public abstract void move();

    @Override
    public String toString() {
        return String.format("%s\nВозраст: %d лет\nСреда обитания: %s",
                getKIND_OF_ANIMAL_AND_NAME(), age, habitat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return KIND_OF_ANIMAL.equals(animal.KIND_OF_ANIMAL) && NAME.equals(animal.NAME) && age.equals(animal.age) && habitat.equals(animal.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(KIND_OF_ANIMAL, NAME, age, habitat);
    }
}
