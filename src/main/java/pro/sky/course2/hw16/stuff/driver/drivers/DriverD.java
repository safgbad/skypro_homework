package pro.sky.course2.hw16.stuff.driver.drivers;

import pro.sky.course2.hw16.stuff.driver.Driver;
import pro.sky.course2.hw16.transport.transports.Bus;

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
