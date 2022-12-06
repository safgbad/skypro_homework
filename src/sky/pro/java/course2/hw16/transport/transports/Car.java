package sky.pro.java.course2.hw16.transport.transports;

import sky.pro.java.course2.hw16.stuff.Queueable;
import sky.pro.java.course2.hw16.stuff.driver.drivers.DriverB;
import sky.pro.java.course2.hw16.transport.enums.Body;
import sky.pro.java.course2.hw16.transport.Transport;

public class Car extends Transport implements Queueable {
    public static final String CLASS_STRING = "Легковой автомобиль";
    private static final Class<?> CLASS = DriverB.class;

    private Body body;
    private boolean isInQueue;

    public Car(String brand, String model, Double engineVolume, DriverB driver) {
        super(brand, model, engineVolume, driver);
        this.body = Body.getRandom();
        driver.setCar(this);
        isInQueue = false;
    }

    public Car(String brand, String model, Double engineVolume, DriverB driver, Body body) {
        super(brand, model, engineVolume, driver);
        this.body = body;
        driver.setCar(this);
        isInQueue = false;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body != null ? body : Body.getRandom();
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
        if (body == null) {
            System.out.println(Transport.NO_TYPE);
        } else {
            System.out.println(body);
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
        return String.format("%s, %s\n%s", CLASS_STRING, body, super.toString());
    }
}
