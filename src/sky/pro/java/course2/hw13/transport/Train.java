package sky.pro.java.course2.hw13.transport;

import sky.pro.java.course2.hw13.Utility;

public class Train extends Transport {
    private static final Integer DEFAULT_NUMBER_OF_CARRIAGES = 5;
    private static final Long DEFAULT_TRIP_DURATION = 3_120L;
    private static final Double DEFAULT_TRIP_PRICE = 81.5;

    private Double tripPrice;
    private Long tripDuration; // seconds
    private String departureStation;
    private String arrivalStation;
    private final Integer NUMBER_OF_CARRIAGES;

    public Train(String BRAND, String MODEL, Integer YEAR, String COUNTRY, String color, Double maxSpeed, Fuel fuel, Boolean isFueled, Double tripPrice, Long tripDuration, String departureStation, String arrivalStation, Integer NUMBER_OF_CARRIAGES) {
        super(BRAND, MODEL, YEAR, COUNTRY, color, maxSpeed, isFueled);
        setFuelType(fuel);
        setTripPrice(tripPrice);
        setTripDuration(tripDuration);
        setDepartureStation(departureStation);
        setArrivalStation(arrivalStation);
        this.NUMBER_OF_CARRIAGES = Utility.isNumberNotNullOrNegative(NUMBER_OF_CARRIAGES) ? NUMBER_OF_CARRIAGES : DEFAULT_NUMBER_OF_CARRIAGES;
    }

    public Double getTripPrice() {
        return tripPrice;
    }

    public Long getTripDuration() {
        return tripDuration;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public Integer getNUMBER_OF_CARRIAGES() {
        return NUMBER_OF_CARRIAGES;
    }

    public void setTripPrice(Double tripPrice) {
        this.tripPrice = Utility.isNumberNotNullOrNegative(tripPrice) ? tripPrice : DEFAULT_TRIP_PRICE;
    }

    public void setTripDuration(Long tripDuration) {
        this.tripDuration = Utility.isNumberNotNullOrNegative(tripDuration) ? tripDuration : DEFAULT_TRIP_DURATION;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = Utility.isStringNotNullOrBlank(departureStation) ? departureStation : DEFAULT;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = Utility.isStringNotNullOrBlank(arrivalStation) ? arrivalStation : DEFAULT;
    }

    @Override
    public void setFuelType(Fuel fuel) {
        if (fuel == Fuel.DIESEL) {
            setFuel(fuel);
        } else {
            setFuel(DEFAULT_FUEL);
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n", DELIMITER, getStringInfo()) + "Цена поездки: " + String.format("%.2f", tripPrice) + "RUB\n" +
                "Время поездки: " + Utility.getTimeWithDays(tripDuration) + '\n' +
                "Станция отправления: " + departureStation + '\n' +
                "Станция прибытия: " + arrivalStation + '\n' +
                "Количество вагонов: " + NUMBER_OF_CARRIAGES + '\n' +
                DELIMITER;
    }
}
