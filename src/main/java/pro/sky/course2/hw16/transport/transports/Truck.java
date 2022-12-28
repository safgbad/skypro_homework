package pro.sky.course2.hw16.transport.transports;

import pro.sky.course2.hw16.stuff.Queueable;
import pro.sky.course2.hw16.stuff.driver.drivers.DriverC;
import pro.sky.course2.hw16.transport.enums.LoadCapacity;
import pro.sky.course2.hw16.transport.Transport;

public class Truck extends Transport implements Queueable {
    public static final String CLASS_STRING = "Грузовой автомобиль";
    private static final Class<?> CLASS = DriverC.class;

    private LoadCapacity loadCapacity;
    private boolean isInQueue;

    public Truck(String brand, String model, Double engineVolume, DriverC driver) {
        super(brand, model, engineVolume, driver);
        this.loadCapacity = LoadCapacity.getRandom();
        driver.setTruck(this);
        isInQueue = false;
    }

    public Truck(String brand, String model, Double engineVolume, DriverC driver, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, driver);
        this.loadCapacity = loadCapacity;
        driver.setTruck(this);
        isInQueue = false;
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
        System.out.printf("%s %s %s успешно прошел обслуживание\n", CLASS_STRING, getBrand(), getModel());
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
    public boolean isInQueue() {
        return isInQueue;
    }

    @Override
    public void setIsInQueue(boolean isInQueue) {
        this.isInQueue = isInQueue;
    }

    @Override
    public String toString() {
        return String.format("%s, %s\n%s", CLASS_STRING, loadCapacity, super.toString());
    }
}
