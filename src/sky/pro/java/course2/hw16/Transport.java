package sky.pro.java.course2.hw16;

import sky.pro.java.course2.hw16.utility.InputCheck;

import java.util.Objects;

public abstract class Transport implements Competing {
    private static final String DEFAULT_BRAND = "undefined";
    private static final String DEFAULT_MODEL = "undefined";
    private static final Double DEFAULT_ENGINE_VOLUME = 2.4;

    private final String BRAND;
    private final String MODEL;
    private Double engineVolume;

    public Transport(String BRAND, String MODEL, Double engineVolume) {
        this.BRAND = InputCheck.isStringNotNullAndNotBlank(BRAND) ? BRAND : DEFAULT_BRAND;
        this.MODEL = InputCheck.isStringNotNullAndNotBlank(MODEL) ? MODEL : DEFAULT_MODEL;
        this.engineVolume = engineVolume;
    }

    public String getBRAND() {
        return BRAND;
    }

    public String getMODEL() {
        return MODEL;
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

    @Override
    public String toString() {
        return String.format("%s %s с двигателем объемом %.1f", BRAND, MODEL, engineVolume);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return BRAND.equals(transport.BRAND) && MODEL.equals(transport.MODEL)
                && engineVolume.equals(transport.engineVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BRAND, MODEL, engineVolume);
    }
}
