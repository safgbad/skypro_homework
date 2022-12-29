package pro.sky.course2.hw16;

import pro.sky.course2.hw16.sponsorship.Sponsor;
import pro.sky.course2.hw16.stuff.Mechanic;
import pro.sky.course2.hw16.stuff.ServiceStation;
import pro.sky.course2.hw16.stuff.driver.drivers.*;
import pro.sky.course2.hw16.transport.Transport;
import pro.sky.course2.hw16.transport.transports.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Transport> transports = new HashSet<>();
        // buses
        transports.add(new Bus("Ikarus", "SP1", 9.0,
                new DriverD("Name7", true, 7)));
        transports.add(new Bus("Ikarus", "SP2", 10.0,
                new DriverD("Name8", true, 8)));
        transports.add(new Bus("Ikarus", "SP3", 11.0,
                new DriverD("Name9", true, 9)));
        // cars
        transports.add(new Car("Audi", "SP1", 3.0,
                new DriverB("Name1", true, 1)));
        transports.add(new Car("Audi", "SP2", 4.0,
                new DriverB("Name2", true, 2)));
        transports.add(new Car("Audi", "SP3", 5.0,
                new DriverB("Name3", true, 3)));
        // trucks
        transports.add(new Truck("Volvo", "SP1", 6.0,
                new DriverC("Name4", true, 4)));
        transports.add(new Truck("Volvo", "SP2", 7.0,
                new DriverC("Name5", true, 5)));
        transports.add(new Truck("Volvo", "SP3", 8.0,
                new DriverC("Name6", true, 6)));
        // sponsors and donations
        Sponsor sponsor1 = new Sponsor("Sponsor 1");
        Iterator<Transport> iterator = transports.iterator();
        sponsor1.makeDonation(iterator.next(), 100000.0);
        sponsor1.makeDonation(iterator.next(), 200000.0);
        sponsor1.makeDonation(iterator.next(), 300000.0);
        Sponsor sponsor2 = new Sponsor("Sponsor 2");
        sponsor2.makeDonation(iterator.next(), 400000.0);
        sponsor2.makeDonation(iterator.next(), 500000.0);
        sponsor2.makeDonation(iterator.next(), 600000.0);
        Sponsor sponsor3 = new Sponsor("Sponsor 3");
        sponsor3.makeDonation(iterator.next(), 700000.0);
        sponsor3.makeDonation(iterator.next(), 800000.0);
        sponsor3.makeDonation(iterator.next(), 900000.0);
        // mechanics
        Mechanic mechanic1 = new Mechanic("Mechanic 1", "Company 1", true, false, false);
        iterator = transports.iterator();
        mechanic1.addTransport(iterator.next());
        mechanic1.addTransport(iterator.next());
        mechanic1.addTransport(iterator.next()); // nope
        Mechanic mechanic2 = new Mechanic("Mechanic 2", "Company 2", true, true, false);
        mechanic2.addTransport(iterator.next());
        mechanic2.addTransport(iterator.next());
        mechanic2.addTransport(iterator.next());
        Mechanic mechanic3 = new Mechanic("Mechanic 3", "Company 3", true, true, true);
        mechanic3.addTransport(iterator.next());
        mechanic3.addTransport(iterator.next());
        mechanic3.addTransport(iterator.next());
        // output
        printInfo(transports);
        System.out.println();
        // service station
        ServiceStation serviceStation = new ServiceStation();
        System.out.println(serviceStation);
        System.out.println();
        serviceStation.addToQueue(transports);
        System.out.println(serviceStation);
        System.out.println();
        serviceStation.toService();
        System.out.println();
        System.out.println(serviceStation);
    }

    public static void printInfo(Set<Transport> transports) {
        for (Transport transport : transports) {
            System.out.println("========================================");
            System.out.println(transport);
            System.out.println("Механики:");
            for (Mechanic mechanic : transport.getMechanics()) {
                System.out.println('\t' + mechanic.getName());
            }
            System.out.println("Спонсоры:");
            for (Sponsor sponsor : transport.getSponsors()) {
                System.out.println('\t' + sponsor.getName());
            }
            System.out.println("========================================");
        }
    }
}
