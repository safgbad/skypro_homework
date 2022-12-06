package sky.pro.java.course2.hw16;

import sky.pro.java.course2.hw16.sponsorship.Sponsor;
import sky.pro.java.course2.hw16.stuff.Mechanic;
import sky.pro.java.course2.hw16.stuff.ServiceStation;
import sky.pro.java.course2.hw16.stuff.driver.drivers.*;
import sky.pro.java.course2.hw16.transport.Transport;
import sky.pro.java.course2.hw16.transport.transports.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transport> transports = new ArrayList<>();
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
        sponsor1.makeDonation(transports.get(0), 100000.0);
        sponsor1.makeDonation(transports.get(1), 200000.0);
        sponsor1.makeDonation(transports.get(2), 300000.0);
        Sponsor sponsor2 = new Sponsor("Sponsor 2");
        sponsor2.makeDonation(transports.get(1), 400000.0);
        sponsor2.makeDonation(transports.get(2), 500000.0);
        sponsor2.makeDonation(transports.get(3), 600000.0);
        Sponsor sponsor3 = new Sponsor("Sponsor 3");
        sponsor3.makeDonation(transports.get(2), 700000.0);
        sponsor3.makeDonation(transports.get(3), 800000.0);
        sponsor3.makeDonation(transports.get(4), 900000.0);
        // mechanics
        Mechanic mechanic1 = new Mechanic("Mechanic 1", "Company 1", true, false, false);
        mechanic1.addTransport(transports.get(3));
        mechanic1.addTransport(transports.get(5));
        mechanic1.addTransport(transports.get(1)); // nope
        Mechanic mechanic2 = new Mechanic("Mechanic 2", "Company 2", true, true, false);
        mechanic2.addTransport(transports.get(4));
        mechanic2.addTransport(transports.get(7));
        mechanic2.addTransport(transports.get(5));
        Mechanic mechanic3 = new Mechanic("Mechanic 3", "Company 3", true, true, true);
        mechanic3.addTransport(transports.get(2));
        mechanic3.addTransport(transports.get(6));
        mechanic3.addTransport(transports.get(5));
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

    public static void printInfo(List<Transport> transports) {
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
