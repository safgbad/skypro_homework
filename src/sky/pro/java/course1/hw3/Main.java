package sky.pro.java.course1.hw3;

public class Main {
    public static void main(String[] args) {
        task1_1();
        task1_2();
        task1_3();
        task2_1();
        task2_2();
        task2_3();
        task3_1();
        task3_2();
        task3_3();
    }

    //Task 1.1
    public static void task1_1() {
        System.out.println("Task 1.1");
        int age = 29;
        if (age >= 18)
            System.out.println("Поздравляем с совершеннолетием!!! ");
        if (age < 18)
            System.out.println("Возраст совершеннолетия еще не наступил, нужно немного подождать.");
        System.out.println("--");
    }

    // Task 1.2
    public static void task1_2() {
        System.out.println("Task 1.2");
        int age = 23;
        if (age >= 7) {
            if (age >= 18) {
                if (age >= 24)
                    System.out.println("Вам пора искать работу");
                if (age < 24)
                    System.out.println("Вы можете обучаться в университете");
            }
            if (age < 18)
                System.out.println("Вы можете ходить в школу");
        }
        if (age < 7)
            System.out.println("Для школы еще рановато...");
        System.out.println("--");
    }

    // Task 1.3
    public static void task1_3() {
        System.out.println("Task 1.3");
        int carCapacity = 102;
        int numberOfSeats = 60;
        int numberOfPassengersInCar = 84;
        if (numberOfPassengersInCar < carCapacity) {
            if (numberOfPassengersInCar < numberOfSeats)
                System.out.println("В вагоне остались сидячие места");
            if (numberOfPassengersInCar >= numberOfSeats)
                System.out.println("В вагоне не осталось сидячих мест, но имеются стоячие");
        }
        if (numberOfPassengersInCar >= carCapacity)
            System.out.println("Свободных мест в вагоне не осталось");
        System.out.println("--");
    }

    // Task 2.1
    public static void task2_1() {
        System.out.println("Task 2.1");
        int age = 29;
        if (age >= 18)
            System.out.println("Поздравляем с совершеннолетием!!! ");
        else
            System.out.println("Возраст совершеннолетия еще не наступил, нужно немного подождать.");
        System.out.println("--");
    }

    // Task 2.2
    public static void task2_2() {
        System.out.println("Task 2.2");
        int age = 27;
        if (age >= 7) {
            if (age >= 18) {
                if (age >= 24)
                    System.out.println("Вам пора искать работу");
                else
                    System.out.println("Вы можете обучаться в университете");
            } else
                System.out.println("Вы можете ходить в школу");
        } else
            System.out.println("Для школы еще рановато...");
        System.out.println("--");
    }

    //Task 2.3
    public static void task2_3() {
        System.out.println("Task 2.3");
        int carCapacity = 102;
        int numberOfSeats = 60;
        int numberOfPassengersInCar = 73;
        if (numberOfPassengersInCar < carCapacity) {
            if (numberOfPassengersInCar < numberOfSeats)
                System.out.println("В вагоне остались сидячие места");
            else
                System.out.println("В вагоне не осталось сидячих мест, но имеются стоячие");
        } else
            System.out.println("Свободных мест в вагоне не осталось");
        System.out.println("--");
    }

    // Task 3.1
    public static void task3_1() {
        System.out.println("Task 3.1");
        int age = 39;
        String whereToGo;
        if (age < 2)
            whereToGo = "в горшок";
        else if (age < 7)
            whereToGo = "в детский сад";
        else if (age < 19)
            whereToGo = "в школу";
        else if (age < 24)
            whereToGo = "в университет";
        else
            whereToGo = "на работу";
        System.out.printf("Если возраст человека равен %d, то ему нужно ходить %s\n", age, whereToGo);
        System.out.println("--");
    }

    // Task 3.2
    public static void task3_2() {
        System.out.println("Task 3.2");
        int age = 10;
        if (age < 5)
            System.out.println("Вы не можете кататься на аттракционе");
        else if (age < 14)
            System.out.println("Вы можете кататься на аттракционе в присутствии взрослого");
        else
            System.out.println("Вы можете кататься на аттракционе");
        System.out.println("--");
    }

    // Task 3.3
    public static void task3_3() {
        System.out.println("Task 3.2");
        int one = Short.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Byte.MAX_VALUE;
        if ((one >= two) && (one >= three))
            System.out.println(one);
        else if ((two >= one) && (two >= three))
            System.out.println(two);
        else
            System.out.println(three);
        System.out.println("--");
    }
}