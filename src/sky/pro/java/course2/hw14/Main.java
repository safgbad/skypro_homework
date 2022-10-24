package sky.pro.java.course2.hw14;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("car1", 4);
        Car car2 = new Car("car2", 4);

        Truck truck = new Truck("truck1", 6);
        Truck truck2 = new Truck("truck2", 8);

        Bicycle bicycle = new Bicycle("bicycle1", 2);
        Bicycle bicycle2 = new Bicycle("bicycle2", 2);

        car.check();
        car2.check();
        truck.check();
        truck2.check();
        bicycle.check();
        bicycle2.check();
    }
}
