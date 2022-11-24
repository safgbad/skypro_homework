package sky.pro.java.course2.hw16;

import sky.pro.java.course2.hw16.transport.*;
import sky.pro.java.course2.hw16.utility.TransportGenerator;

import java.util.ArrayList;

import static sky.pro.java.course2.hw16.utility.Printer.printObjects;
import static sky.pro.java.course2.hw16.utility.TransportGenerator.check;

public class Main {
    public static void main(String[] args) {
        TransportGenerator<Car> carGenerator = new TransportGenerator<>(9, 6,
                2.4, 4.8, Car.class);
        ArrayList<Car> cars = carGenerator.generateVehicles(4);
        printObjects(cars);
        System.out.println();
        check(cars.get(0));
        System.out.println("--");

        TransportGenerator<Truck> truckGenerator = new TransportGenerator<>(6, 3,
                4.7, 8.1, Truck.class);
        ArrayList<Truck> trucks = truckGenerator.generateVehicles(4);
        printObjects(trucks);
        System.out.println();
        check(trucks.get(0));
        System.out.println("--");

        TransportGenerator<Bus> busGenerator = new TransportGenerator<>(8, 5,
                3.3, 6.4, Bus.class);
        ArrayList<Bus> buses = busGenerator.generateVehicles(4);
        printObjects(buses);
        System.out.println();
        check(buses.get(0));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");

        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Андреев Андрей Андреевич", cars.get(2),
                true, 7));
        drivers.add(new Driver("Васильев Василий Васильевич", cars.get(1),
                false, null));
        drivers.add(new Driver("Никитин Никита Никитович", cars.get(0),
                true, 3));
        drivers.add(new Driver("Георгиев Георгий Георгиевич", cars.get(3),
                false, -1));

        drivers.add(new Driver("Михайлов Михаил Михайлович", trucks.get(2),
                true, 9));

        drivers.add(new Driver("Евгеньев Евгений Евгеньевич", buses.get(1),
                true, 4));

        printObjects(drivers);
    }
}
