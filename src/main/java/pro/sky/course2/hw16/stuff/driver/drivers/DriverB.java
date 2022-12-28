package pro.sky.course2.hw16.stuff.driver.drivers;

import pro.sky.course2.hw16.stuff.driver.Driver;
import pro.sky.course2.hw16.transport.transports.Car;

public class DriverB extends Driver {
    private Car car;

    public DriverB(String fullName, Boolean doesHaveDrivingLicense, Integer experience) {
        super(fullName, doesHaveDrivingLicense, experience);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
