package pro.sky.course2.hw16.transport;

import pro.sky.course2.hw16.stuff.Mechanic;
import pro.sky.course2.hw16.stuff.driver.Driver;
import pro.sky.course2.hw16.sponsorship.Sponsor;
import pro.sky.utility.ValueCheck;

import java.util.*;

public abstract class Transport implements Competing {
    public static final String NO_TYPE = "Данных по транспортному средству недостаточно";

    private static final String DEFAULT_BRAND = "undefined";
    private static final String DEFAULT_MODEL = "undefined";
    private static final Double DEFAULT_ENGINE_VOLUME = 2.4;

    private final String brand;
    private final String model;
    private Double engineVolume;
    private Driver driver;
    private final Set<Sponsor> sponsors;
    private final Set<Mechanic> mechanics;

    public Transport(String brand, String model, Double engineVolume, Driver driver) {
        this.brand = ValueCheck.isStringNotNullAndNotBlank(brand) ? brand : DEFAULT_BRAND;
        this.model = ValueCheck.isStringNotNullAndNotBlank(model) ? model : DEFAULT_MODEL;
        setEngineVolume(engineVolume);
        setDriver(driver);
        sponsors = new HashSet<>();
        mechanics = new HashSet<>();
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

    public Driver getDriver() {
        return driver;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = ValueCheck.isNumberNotNullAndNotNegative(engineVolume) ?
                engineVolume : DEFAULT_ENGINE_VOLUME;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean addSponsor(Sponsor sponsor) {
        if (sponsor != null
                && sponsor.getDonations().stream().anyMatch(donation -> donation.getTransport().equals(this))) {
            return sponsors.add(sponsor);
        }
        return false;
    }

    public boolean addMechanic(Mechanic mechanic) {
        if (mechanic != null
                && mechanic.getTransports().stream().anyMatch(transport -> transport.equals(this))) {
            return mechanics.add(mechanic);
        }
        return false;
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void printType();

    public boolean getDiagnosed() {
        System.out.printf("Транспортное средство %s %s не нуждается в диагностике\n", brand, model);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return brand.equals(transport.brand) && model.equals(transport.model) && engineVolume.equals(transport.engineVolume) && driver.equals(transport.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, driver);
    }

    @Override
    public String toString() {
        return String.format("%s %s с двигателем объемом %.1f\n%s", brand, model, engineVolume, driver);
    }
}
