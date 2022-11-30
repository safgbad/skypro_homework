package sky.pro.java.course2.hw16.transport.transports;

import sky.pro.java.course2.hw16.driver.Driver;
import sky.pro.java.course2.hw16.driver.drivers.DriverC;
import sky.pro.java.course2.hw16.transport.enums.LoadCapacity;
import sky.pro.java.course2.hw16.transport.Transport;

public class Truck extends Transport {
    private static final String CLASS_STRING = "Грузовой автомобиль";
    private static final Class<?> CLASS = DriverC.class;

    private LoadCapacity loadCapacity;

    public Truck(String brand, String model, Double engineVolume, Driver driver) {
        super(brand, model, engineVolume, driver);
        this.loadCapacity = LoadCapacity.getRandom();
    }

    public Truck(String brand, String model, Double engineVolume, Driver driver, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, driver);
        this.loadCapacity = loadCapacity;
    }


    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity != null ? loadCapacity : LoadCapacity.getRandom();
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
        if (loadCapacity == null) {
            System.out.println(Transport.NO_TYPE);
        } else {
            System.out.println(loadCapacity);
        }
    }

    @Override
    public boolean getDiagnosed() {
        if (getDriver().getClass() != CLASS || !getDriver().getDoesHaveDrivingLicense()) {
            throw new RuntimeException(String.format("Необходимо указать тип прав для %s %s",
                    getBrand(), getModel()));
        }
        System.out.printf("%s %s %s успешно прошел диагностику\n", CLASS_STRING, getBrand(), getModel());
        return true;
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
        return String.format("%s, %s\n%s", CLASS_STRING, loadCapacity, super.toString());
    }
}
