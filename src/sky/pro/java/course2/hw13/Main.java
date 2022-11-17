package sky.pro.java.course2.hw13;

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
        System.out.println("--");

        System.out.println("Cars:");
        Car lada = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия");
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3, "черный", 2020, "Германия");
        Car bmw = new Car("BMW", "Z8", 3, "черный", 2021, "Германия");
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея");
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");
        Car[] cars = new Car[] {lada, audi, bmw, kia, hyundai};
        printObjects(cars);
        System.out.println("--");

        System.out.println("Flowers:");
        Flower rose = new Flower("Роза обыкновенная", null, "Нидерланды", 35.59);
        Flower chrysanthemum = new Flower("Хризантема", null, null, 15, 5);
        Flower peony = new Flower("Пион", null, "Великобритания", 69.9, 1);
        Flower gypsophila = new Flower("Гипсофила", null, "Турция", 19.5, 10);
        Flower[] flowers = new Flower[] {rose, chrysanthemum, peony, gypsophila};
        printObjects(flowers);
        System.out.println("--");

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
