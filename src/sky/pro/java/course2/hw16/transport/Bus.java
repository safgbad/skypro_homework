package sky.pro.java.course2.hw16.transport;

import sky.pro.java.course2.hw16.Transport;
import sky.pro.java.course2.hw16.enums.Capacity;

public class Bus extends Transport {
    private static final String CLASS = "Автобус";

    private Capacity capacity;

    public Bus(String BRAND, String MODEL, Double engineVolume) {
        super(BRAND, MODEL, engineVolume);
        this.capacity = Capacity.getRandom();
    }

    public Bus(String BRAND, String MODEL, Double engineVolume, Capacity capacity) {
        super(BRAND, MODEL, engineVolume);
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
        System.out.printf("%s %s %s начал движение\n", CLASS, getBrand(), getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("%s %s %s остановился\n", CLASS, getBrand(), getModel());
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
        return String.format("%s %s\n%s", CLASS, super.toString(), capacity);
    }
}