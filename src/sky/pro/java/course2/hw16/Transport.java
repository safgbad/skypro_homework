package sky.pro.java.course2.hw16;

import sky.pro.java.course2.hw16.utility.InputCheck;

import java.util.Objects;

public abstract class Transport implements Competing {
    public static final String NO_TYPE = "Данных по транспортному средству недостаточно";

    private static final String DEFAULT_BRAND = "undefined";
    private static final String DEFAULT_MODEL = "undefined";
    private static final Double DEFAULT_ENGINE_VOLUME = 2.4;

    private final String brand;
    private final String model;
    private Double engineVolume;

    public Transport(String brand, String model, Double engineVolume) {
        this.brand = InputCheck.isStringNotNullAndNotBlank(brand) ? brand : DEFAULT_BRAND;
        this.model = InputCheck.isStringNotNullAndNotBlank(model) ? model : DEFAULT_MODEL;
        this.engineVolume = engineVolume;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = InputCheck.isNumberNotNullAndNotNegative(engineVolume) ?
                engineVolume : DEFAULT_ENGINE_VOLUME;
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void printType();

    @Override
    public String toString() {
        return String.format("%s %s с двигателем объемом %.1f", brand, model, engineVolume);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return brand.equals(transport.brand) && model.equals(transport.model)
                && engineVolume.equals(transport.engineVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}
