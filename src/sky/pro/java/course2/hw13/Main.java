package sky.pro.java.course2.hw13;

public class Main {
    public static void main(String[] args) {
        // С Вашего позволения не буду делать вариант с прямым доступом и дефолтными полями
        // Task 1.1
        System.out.println("Task 1.1");
        Human maxim = new Human(1988, "Максим", "Минск");
        Human anya = new Human(1993, "Аня", "Москва");
        Human katya = new Human(1992, "Катя", "Калининград");
        Human artem = new Human(1995, "Артем", "Москва");
        Human[] humans = new Human[] {maxim, anya, katya, artem};
        printObjects(humans);
        System.out.println("--");

        // Task 1.2 (2.1)
        System.out.println("Task 1.2 (2.1)");
        maxim.setJobTitle("бренд-менеджер");
        anya.setJobTitle("методист образовательных программ");
        katya.setJobTitle("продакт-менеджер");
        artem.setJobTitle("директор по развитию бизнеса");
        printObjects(humans);
        System.out.println("--");

        // Task 1.3 (2.2)
        System.out.println("Task 1.3 (2.2)");
        Car lada = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия");
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3, "черный", 2020, "Германия");
        Car bmw = new Car("BMW", "Z8", 3, "черный", 2021, "Германия");
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея");
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");
        Car[] cars = new Car[] {lada, audi, bmw, kia, hyundai};
        printObjects(cars);
        System.out.println("--");
    }

    public static void printObjects(Object[] objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    public static String checkIfBlankAndReturn(String str, String oldStr) {
        return str != null && !str.isBlank() ? str : oldStr;
    }
}
