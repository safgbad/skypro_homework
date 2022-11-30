package sky.pro.java.course2.hw16;

import sky.pro.java.course2.hw16.driver.drivers.*;
import sky.pro.java.course2.hw16.transport.Transport;
import sky.pro.java.course2.hw16.transport.transports.*;

import java.util.ArrayList;

import static sky.pro.java.course2.hw16.utility.Printer.printObjects;

public class Main {
    public static void main(String[] args) {
        // жопа горит с ебучих методистов
        // ну вот нахуя дженерики в этих гонках, за уши не притянуть блять
        // фырив ажфыиов аофУО ОЛФВИ АЩФЫИ Пфыт зЫИТ ЕАДыт. аюолЫВА ЛЖТФыщ ивфыщшзэ аШЗ
        ArrayList<Transport> transports = new ArrayList<>();

        transports.add(new Bus("Ikarus", "SP1", 9.0,
                new DriverD("Name7", true, 7)));
        transports.add(new Bus("Ikarus", "SP2", 10.0,
                new DriverD("Name8", true, 8)));
        transports.add(new Bus("Ikarus", "SP3", 11.0,
                new DriverD("Name9", true, 9)));

        transports.add(new Car("Audi", "SP1", 3.0,
                new DriverB("Name1", true, 1)));
        transports.add(new Car("Audi", "SP2", 4.0,
                new DriverB("Name2", true, 2)));
        transports.add(new Car("Audi", "SP3", 5.0,
                new DriverB("Name3", true, 3)));

        transports.add(new Truck("Volvo", "SP1", 6.0,
                new DriverC("Name4", true, 4)));
        transports.add(new Truck("Volvo", "SP2", 7.0,
                new DriverD("Name5", true, 5)));
        transports.add(new Truck("Volvo", "SP3", 8.0,
                new DriverC("Name6", true, 6)));

        printObjects(transports);
        diagnoseTransports(transports);
    }

    public static void diagnoseTransports(ArrayList<Transport> transports) {
        for (Transport transport : transports) {
            transport.getDiagnosed();
        }
    }
}
