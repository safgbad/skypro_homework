package sky.pro.java.course2.hw16.transport;

import sky.pro.java.course2.hw16.Transport;
import sky.pro.java.course2.hw16.enums.Body;

public class Car extends Transport {
    private static final String CLASS = "Легковой автомобиль";

    private Body body;

    public Car(String brand, String model, Double engineVolume) {
        super(brand, model, engineVolume);
        this.body = Body.getRandom();
    }

    public Car(String brand, String model, Double engineVolume, Body body) {
        super(brand, model, engineVolume);
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body != null ? body : Body.getRandom();
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
        if (body == null) {
            System.out.println(Transport.NO_TYPE);
        } else {
            System.out.println(body);
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
        return String.format("%s %s\n%s", CLASS, super.toString(), body);
    }
}
