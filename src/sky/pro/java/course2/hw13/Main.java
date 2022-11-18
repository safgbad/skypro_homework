package sky.pro.java.course2.hw13;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Humans:");
        Human maxim = new Human(1988, "Максим", "Минск", "бренд-менеджер");
        Human anya = new Human(1993, "Аня", "Москва", "методист образовательных программ");
        Human katya = new Human(1992, "Катя", "Калининград", "продакт-менеджер");
        Human artem = new Human(1995, "Артем", "Москва", "директор по развитию бизнеса");
        Human vladimir = new Human(2001, "Владимир", "Казань");
        Human[] humans = new Human[] {maxim, anya, katya, artem, vladimir};
        printObjects(humans);
        System.out.println("----------------------------------------");

        System.out.println("Cars:");
        Car lada = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия",
                Car.Transmission.MANUAL, Car.Body.SEDAN, "а123бв456", -5, false,
                new Car.Key(false, false), null);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3, "черный", 2020, "Германия",
                Car.Transmission.ROBOTIC, Car.Body.SEDAN, "Я999яя999", 5, true,
                new Car.Key(true, true), new Car.Insurance(LocalDate.now(), 37937.23, "FK41931VH"));
        Car bmw = new Car("BMW", "Z8", 3, "черный", 2021, "Германия",
                Car.Transmission.VARIABLE, Car.Body.CONVERTIBLE, "п461ыд382", 2, false,
                new Car.Key(true, true), new Car.Insurance(LocalDate.now().minusDays(5), 41394.68, "3783263628"));
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея",
                Car.Transmission.AUTOMATIC, Car.Body.SUV, null, 7, true,
                new Car.Key(true, false), null);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея",
                Car.Transmission.MANUAL, Car.Body.HATCHBACK, "Zg342sf123", 0, true,
                new Car.Key(false, true), null);
        Car[] cars = new Car[] {lada, audi, bmw, kia, hyundai};
        lada.changeTiresToSeasonal();
        printObjects(cars);
        System.out.println("----------------------------------------");

        System.out.println("Flowers:");
        Bouquet.Flower rose = new Bouquet.Flower("Роза обыкновенная", null, "Нидерланды", 35.59);
        Bouquet.Flower chrysanthemum = new Bouquet.Flower("Хризантема", null, null, 15, 5);
        Bouquet.Flower peony = new Bouquet.Flower("Пион", null, "Великобритания", 69.9, 1);
        Bouquet.Flower gypsophila = new Bouquet.Flower("Гипсофила", null, "Турция", 19.5, 10);
        Bouquet.Flower[] flowers = new Bouquet.Flower[] {rose, chrysanthemum, peony, gypsophila};
        printObjects(flowers);
        System.out.println("----------------------------------------");

        System.out.println("Bouquet:");
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(rose, 3);
        bouquet.addFlower(chrysanthemum, 5);
        bouquet.addFlower(gypsophila);
        System.out.println(bouquet);
    }

    public static void printObjects(Object[] objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
