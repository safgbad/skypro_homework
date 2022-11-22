package sky.pro.java.course2.hw13.transport;

public class Bus extends Transport {
    public Bus(String BRAND, String MODEL, Integer YEAR, String COUNTRY, String color, Double maxSpeed, Fuel fuel, Boolean isFueled) {
        super(BRAND, MODEL, YEAR, COUNTRY, color, maxSpeed, isFueled);
        setFuelType(fuel);
    }

    @Override
    public void setFuelType(Fuel fuel) {
        if (fuel == Fuel.GASOLINE || fuel == Fuel.DIESEL) {
            setFuel(fuel);
        } else {
            setFuel(DEFAULT_FUEL);
        }
    }

    @Override
    public String toString() {
        return DELIMITER + '\n' + getStringInfo() + '\n' + DELIMITER;
    }
}
