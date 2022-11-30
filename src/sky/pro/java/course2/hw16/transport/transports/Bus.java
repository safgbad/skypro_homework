package sky.pro.java.course2.hw16.transport.transports;

import sky.pro.java.course2.hw16.driver.Driver;
import sky.pro.java.course2.hw16.driver.drivers.DriverD;
import sky.pro.java.course2.hw16.transport.enums.Capacity;
import sky.pro.java.course2.hw16.transport.Transport;

public class Bus extends Transport {
    private static final String CLASS_STRING = "Автобус";
    private static final Class<?> CLASS = DriverD.class;

    private Capacity capacity;

    public Bus(String BRAND, String MODEL, Double engineVolume, Driver driver) {
        super(BRAND, MODEL, engineVolume, driver);
        this.capacity = Capacity.getRandom();
    }

    public Bus(String BRAND, String MODEL, Double engineVolume, Driver driver, Capacity capacity) {
        super(BRAND, MODEL, engineVolume, driver);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity != null ? capacity : Capacity.getRandom();
    }

    @Override
    public void startMoving() {
        System.out.printf("%s %s %s начал движение\n", CLASS_STRING, getBrand(), getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("%s %s %s остановился\n", CLASS_STRING, getBrand(), getModel());
    }

    @Override
    public void printType() {
        if (capacity == null) {
            System.out.println(Transport.NO_TYPE);
        } else {
            System.out.println(capacity);
        }
    }

    @Override
    public void pitStop() {
        System.out.printf("%s %s %s на пит-стопе\n", CLASS_STRING, getBrand(), getModel());
    }

    @Override
    public void showBestLapTime() {
        System.out.printf("Лучшее время %s %s: %d мин %d сек\n", getBrand(), getModel(),
                (int) (60 * Math.random()), (int) (60 * Math.random()));
    }

    @Override
    public void showMaxSpeed() {
        System.out.printf("Максимальная скорость %s %s: %d км/ч\n", getBrand(), getModel(),
                (int) (270 * Math.random()));
    }

    @Override
    public String toString() {
        return String.format("%s, %s\n%s", CLASS_STRING, capacity, super.toString());
    }
}