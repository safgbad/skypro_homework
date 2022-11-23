package sky.pro.java.course2.hw16.transport;

import sky.pro.java.course2.hw16.Transport;

public class Bus extends Transport {
    private static final String CLASS = "Автобус";

    public Bus(String BRAND, String MODEL, Double engineVolume) {
        super(BRAND, MODEL, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.printf("%s %s %s начал движение\n", CLASS, getBRAND(), getMODEL());
    }

    @Override
    public void stopMoving() {
        System.out.printf("%s %s %s остановился\n", CLASS, getBRAND(), getMODEL());
    }

    @Override
    public void pitStop() {
        System.out.printf("%s %s %s на пит-стопе\n", CLASS, getBRAND(), getMODEL());
    }

    @Override
    public void showBestLapTime() {
        System.out.printf("Лучшее время %s %s: %d мин %d сек\n", getBRAND(), getMODEL(),
                (int) (60 * Math.random()), (int) (60 * Math.random()));
    }

    @Override
    public void showMaxSpeed() {
        System.out.printf("Максимальная скорость %s %s: %d км/ч\n", getBRAND(), getMODEL(),
                (int) (270 * Math.random()));
    }

    @Override
    public String toString() {
        return String.format("%s %s", CLASS, super.toString());
    }
}