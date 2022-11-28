package sky.pro.java.course2.hw16.transport;

import sky.pro.java.course2.hw16.Transport;
import sky.pro.java.course2.hw16.enums.LoadCapacity;

public class Truck extends Transport {
    private static final String CLASS = "Грузовой автомобиль";

    private LoadCapacity loadCapacity;

    public Truck(String BRAND, String MODEL, Double engineVolume) {
        super(BRAND, MODEL, engineVolume);
        this.loadCapacity = LoadCapacity.getRandom();
    }

    public Truck(String BRAND, String MODEL, Double engineVolume, LoadCapacity loadCapacity) {
        super(BRAND, MODEL, engineVolume);
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
        System.out.printf("%s %s %s начал движение\n", CLASS, getBrand(), getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("%s %s %s остановился\n", CLASS, getBrand(), getModel());
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
    public void pitStop() {
        System.out.printf("%s %s %s на пит-стопе\n", CLASS, getBrand(), getModel());
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
        return String.format("%s %s\n%s", CLASS, super.toString(), loadCapacity);
    }
}
