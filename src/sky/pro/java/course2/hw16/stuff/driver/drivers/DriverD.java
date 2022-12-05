package sky.pro.java.course2.hw16.stuff.driver.drivers;

import sky.pro.java.course2.hw16.stuff.driver.Driver;
import sky.pro.java.course2.hw16.transport.transports.Bus;

public class DriverD extends Driver {
    private Bus bus;

    public DriverD(String fullName, Boolean doesHaveDrivingLicense, Integer experience) {
        super(fullName, doesHaveDrivingLicense, experience);
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
