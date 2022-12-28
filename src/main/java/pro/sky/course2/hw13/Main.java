package pro.sky.course2.hw13;

import pro.sky.course2.hw13.transport.*;

import java.time.LocalDate;

import static pro.sky.course2.hw13.Utility.printObjects;

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

        System.out.println("Flowers:");
        Bouquet.Flower rose = new Bouquet.Flower("Роза обыкновенная", null, "Нидерланды", 35.59);
        Bouquet.Flower chrysanthemum = new Bouquet.Flower("Хризантема", null, null, 15.0, 5);
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
        System.out.println("----------------------------------------");

        System.out.println("Cars:");
        Car lada = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия", 190.0, Transport.Fuel.GASOLINE, false,
                Car.Transmission.MANUAL, Car.Body.SEDAN, "а123бв456", -5, false,
                new Car.Key(false, false), null);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германия", 220.0, Transport.Fuel.GASOLINE, true,
                Car.Transmission.ROBOTIC, Car.Body.SEDAN, "Я999яя999", 5, true,
                new Car.Key(true, true), new Car.Insurance(LocalDate.now(), 37937.23, "FK41931VH"));
        Car bmw = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германия", 270.0, Transport.Fuel.DIESEL, true,
                Car.Transmission.VARIABLE, Car.Body.CONVERTIBLE, "п461ыд382", 2, false,
                new Car.Key(true, true), new Car.Insurance(LocalDate.now().minusDays(5), 41394.68, "3783263628"));
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея", 190.0, Transport.Fuel.DIESEL, false,
                Car.Transmission.AUTOMATIC, Car.Body.SUV, null, 7, true,
                new Car.Key(true, false), null);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея", 210.0, null, null,
                Car.Transmission.MANUAL, Car.Body.HATCHBACK, "Zg342sf123", 0, true,
                new Car.Key(false, true), null);
        Car[] cars = new Car[] {lada, audi, bmw, kia, hyundai};
        lada.changeTiresToSeasonal();
        kia.refill(Transport.Fuel.DIESEL);
        printObjects(cars);
        System.out.println("----------------------------------------");

        System.out.println("Trains:");
        Train lastochka = new Train("Ласточка", "B-901", 2011, null, null, 301.0, Transport.Fuel.DIESEL, true,
                3500.0, 12423145L - 3120L, "Белорусский вокзал", "Минск-Пассажирский", 11);
        Train leningrad = new Train("Ленинград", "D-125", 2019, null, null, 270.0, Transport.Fuel.GASOLINE, false,
                1700.0, null, "Ленинградский вокзал", "Ленинград-Пассажирский", 8);
        Train[] trains = new Train[] {lastochka, leningrad};
        leningrad.refill(Transport.Fuel.GASOLINE);
        printObjects(trains);
        System.out.println("----------------------------------------");

        System.out.println("Buses:");
        Bus ikarus = new Bus("Ikarus", "250", 1973, "Венгрия", "желтый", 120.0, Transport.Fuel.ELECTRICITY, true);
        Bus pazik = new Bus("ПАЗ", "3205", 1995, "Россия", null, 90.0, Transport.Fuel.GASOLINE, false);
        Bus gazel = new Bus("ГАЗель", "NEXT", 2019, null, "красный", 95.0, Transport.Fuel.DIESEL, true);
        Bus[] buses = new Bus[] {ikarus, pazik, gazel};
        pazik.refill(Transport.Fuel.ELECTRICITY);
        printObjects(buses);
    }
}
