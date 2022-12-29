package pro.sky.course2.hw13.transport;

import pro.sky.course2.hw13.Utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;
import java.util.regex.Pattern;

public class Car extends Transport {
    public enum Body {
        UNDEFINED("Не определено"),
        SEDAN("Седан"),
        HATCHBACK("Хэтчбэк"),
        COUPE("Купе"),
        SPORTS_CAR("Спорт-кар"),
        STATION_WAGON("Универсал"),
        CONVERTIBLE("Кабриолет"),
        SUV("Внедорожник"),
        MINIVAN("Минивэн"),
        PICKUP_TRUCK("Пикап");

        private final String BODY;

        Body(String BODY) {
            this.BODY = BODY;
        }

        @Override
        public String toString() {
            return BODY;
        }
    }

    public enum Transmission {
        UNDEFINED("Не определено"),
        MANUAL("Ручная"),
        AUTOMATIC("Автомат"),
        ROBOTIC("Робот"),
        VARIABLE("Вариатор");

        private final String TRANSMISSION;

        Transmission(String TRANSMISSION) {
            this.TRANSMISSION = TRANSMISSION;
        }

        @Override
        public String toString() {
            return TRANSMISSION;
        }
    }

    public static class Key {
        private final Boolean REMOTE_START;
        private final Boolean KEYLESS_ACCESS;

        public Key(Boolean REMOTE_START, Boolean KEYLESS_ACCESS) {
            this.REMOTE_START = REMOTE_START;
            this.KEYLESS_ACCESS = KEYLESS_ACCESS;
        }

        public Boolean isREMOTE_START() {
            return REMOTE_START;
        }

        public Boolean isKEYLESS_ACCESS() {
            return KEYLESS_ACCESS;
        }

        @Override
        public String toString() {
            return String.format("Ключ: [Удаленный запуск двигателя: %s, Бесключевой доступ: %s]",
                    REMOTE_START ? "да" : "нет", KEYLESS_ACCESS ? "да" : "нет");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return REMOTE_START == key.REMOTE_START && KEYLESS_ACCESS == key.KEYLESS_ACCESS;
        }

        @Override
        public int hashCode() {
            return Objects.hash(REMOTE_START, KEYLESS_ACCESS);
        }
    }

    public static class Insurance {
        private static final Double DEFAULT_COST = 500_000.0;

        private final LocalDate VALIDITY;
        private final Double COST;
        private final String NUMBER;

        public Insurance(LocalDate VALIDITY, double COST, String NUMBER) {
            this.VALIDITY = VALIDITY != null ? VALIDITY : LocalDate.now();
            this.COST = Utility.isNumberNotNullOrNegative(COST) ? COST : DEFAULT_COST;
            this.NUMBER = Utility.isStringNotNullOrBlank(NUMBER) && NUMBER.length() == 9 ? NUMBER : DEFAULT;
        }

        public LocalDate getVALIDITY() {
            return VALIDITY;
        }

        public double getCOST() {
            return COST;
        }

        public String getNUMBER() {
            return NUMBER;
        }

        private boolean checkValidity() {
            return VALIDITY.isBefore(LocalDate.now().plusDays(1));
        }

        @Override
        public String toString() {
            return String.format("[Срок действия: %s, Стоимость: %.2f, Номер: %s]", VALIDITY, COST, NUMBER);
        }
    }

    private static final Double DEFAULT_ENGINE_VOLUME = 1.5;
    private static final Integer DEFAULT_NUMBER_OF_SEATS = 5;

    private double engineVolume;
    private Transmission transmission;
    private final Body BODY;
    private String registrationNumber;
    private final Integer NUMBER_OF_SEATS;
    private boolean areTiresWinter;
    private Key key;
    private Insurance insurance;

    public Car(String BRAND, String MODEL, Double engineVolume, String color, Integer YEAR, String COUNTRY, Double maxSpeed, Fuel fuel, Boolean isFueled,
               Transmission transmission, Body BODY, String registrationNumber, Integer NUMBER_OF_SEATS, Boolean areTiresWinter, Key key, Insurance insurance) {
        super(BRAND, MODEL, YEAR, COUNTRY, color, maxSpeed, isFueled);
        setFuelType(fuel);
        this.engineVolume = Utility.isNumberNotNullOrNegative(engineVolume) ? engineVolume : DEFAULT_ENGINE_VOLUME;
        this.transmission = transmission != null ? transmission : Transmission.UNDEFINED;
        this.BODY = BODY != null ? BODY : Body.UNDEFINED;
        this.registrationNumber = checkRegistrationNumber(registrationNumber) ? registrationNumber : DEFAULT;
        this.NUMBER_OF_SEATS = Utility.isNumberNotNullOrNegative(NUMBER_OF_SEATS) ? NUMBER_OF_SEATS : DEFAULT_NUMBER_OF_SEATS;
        this.areTiresWinter = areTiresWinter != null ? areTiresWinter : false;
        this.key = key;
        this.insurance = insurance;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Body getBODY() {
        return BODY;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNUMBER_OF_SEATS() {
        return NUMBER_OF_SEATS;
    }

    public boolean areTiresWinter() {
        return areTiresWinter;
    }

    public Key getKey() {
        return key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setAreTiresWinter(boolean areTiresWinter) {
        this.areTiresWinter = areTiresWinter;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public void setFuelType(Fuel fuel) {
        setFuel(fuel);
    }

    public void changeTiresToSeasonal() {
        Month currentMonth =  LocalDateTime.now().getMonth();
        switch (currentMonth) {
            case NOVEMBER:
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
            case MARCH:
            case APRIL:
                areTiresWinter = true;
                break;
            default:
                areTiresWinter = false;
        }
    }

    public static boolean checkRegistrationNumber(String registrationNumber) {
        String regex = "^[А-Яа-я]\\d{3}[А-Яа-я]{2}\\d{3}";
        Pattern pattern = Pattern.compile(regex);
        return registrationNumber != null && pattern.matcher(registrationNumber).matches();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("%s\n%s\n" +
                        "Объем двигателя: %.1f л.\nПосадочных мест: %d\nРезина: %s\n",
                DELIMITER, getStringInfo(), engineVolume, NUMBER_OF_SEATS, areTiresWinter ? "Зимняя" : "Летняя"));
        if (transmission != null) stringBuilder.append("Коробка передач: ").append(transmission).append('\n');
        if (BODY != null) stringBuilder.append("Тип кузова: ").append(BODY).append('\n');
        stringBuilder.append("Регистрационный номер: ").append(registrationNumber).append('\n');
        if (key != null) stringBuilder.append(key).append('\n');
        stringBuilder.append("Страховка: ");
        if (insurance != null && insurance.checkValidity()) {
            stringBuilder.append("да ").append(insurance);
        } else if (insurance != null && !insurance.checkValidity()) {
            stringBuilder.append("просрочена ").append(insurance);
        } else {
            stringBuilder.append("нет");
        }
        stringBuilder.append('\n').append(DELIMITER);
        return stringBuilder.toString();
    }
}
