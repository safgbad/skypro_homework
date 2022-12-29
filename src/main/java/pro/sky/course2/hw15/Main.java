package pro.sky.course2.hw15;

import pro.sky.course2.hw15.animals.*;

public class Main {
    public static void main(String[] args) {
        Mammal gazelle = new Mammal("Газель", "Гузель", 7, "Саванна", 50.0, Mammal.Nutrition.HERBIVORE);
        Mammal giraffe = new Mammal("Жираф", "Анатолий", 12, "Саванна", 60.0, Mammal.Nutrition.HERBIVORE);
        Mammal horse = new Mammal("Лошадь", "Маша", 4, "Степь", 88.0, Mammal.Nutrition.HERBIVORE);

        Mammal hyena = new Mammal("Гиена", "Василиса", 6, "Саванна", 64.0, Mammal.Nutrition.CARNIVOROUS);
        Mammal tiger = new Mammal("Тигр", "Андрей", 5, "Саванна", 55.0, Mammal.Nutrition.CARNIVOROUS);
        Mammal bear = new Mammal("Медведь", "Михаил", 9, "Тайга", 56.0, Mammal.Nutrition.OMNIVORE);

        Amphibian frog = new Amphibian("Лягушка", "Пепе", 2, "Болото");
        Amphibian grassSnake = new Amphibian("Уж пресноводный", "Константин", 1, "Река");

        Bird peacock = new Bird("Павлин", "Анна", 4, "Джунгли", false);
        Bird penguin = new Bird("Пингвин", "Ростислав", 3, "Антарктида", false);
        Bird dodo = new Bird("Додо", "Никита", null, "Вымер :(", false);

        Bird gull = new Bird("Чайка", "Полина", 6, "Море", true);
        Bird albatross = new Bird("Альбатрос", "Виктор", 1, "Южный океан", true);
        Bird falcon = new Bird("Сокол", "Диана", 10, "Везде", true);

        Animal[] animals = new Animal[] {gazelle, giraffe, horse, hyena, tiger, bear, frog, grassSnake, peacock, penguin, dodo, gull, albatross, falcon};
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
