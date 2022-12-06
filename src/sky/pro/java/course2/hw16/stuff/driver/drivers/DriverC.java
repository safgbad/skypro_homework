package sky.pro.java.course2.hw16.stuff.driver.drivers;

import sky.pro.java.course2.hw16.stuff.driver.Driver;
import sky.pro.java.course2.hw16.transport.transports.Truck;

public class DriverC extends Driver {
    private Truck truck;

    public DriverC(String fullName, Boolean doesHaveDrivingLicense, Integer experience) {
        super(fullName, doesHaveDrivingLicense, experience);
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
