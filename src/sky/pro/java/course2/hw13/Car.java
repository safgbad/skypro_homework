package sky.pro.java.course2.hw13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
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

        private final String body;

        Body(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return body;
        }
    }

    public enum Transmission {
        UNDEFINED("Не определено"),
        MANUAL("Ручная"),
        AUTOMATIC("Автомат"),
        ROBOTIC("Робот"),
        VARIABLE("Вариатор");

        private final String transmission;

        Transmission(String transmission) {
            this.transmission = transmission;
        }

        @Override
        public String toString() {
            return transmission;
        }
    }

    public static class Key {
        private static final Key DEFAULT_KEY = new Key(false, false);

        private final boolean REMOTE_START;
        private final boolean KEYLESS_ACCESS;

        public Key(boolean REMOTE_START, boolean KEYLESS_ACCESS) {
            this.REMOTE_START = REMOTE_START;
            this.KEYLESS_ACCESS = KEYLESS_ACCESS;
        }

        public boolean isREMOTE_START() {
            return REMOTE_START;
        }

        public boolean isKEYLESS_ACCESS() {
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
        private LocalDate validity = LocalDate.now();
        private double cost = 1;
        private String number = "AA00000AA";

        public Insurance(LocalDate validity, double cost, String number) {
            if (validity != null) this.validity = validity;
            if (cost > 0) this.cost = cost;
            if (number.length() == 9) this.number = number;
        }

        public LocalDate getValidity() {
            return validity;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        private boolean checkValidity() {
            return validity.isBefore(LocalDate.now().plusDays(1));
        }

        @Override
        public String toString() {
            return String.format("[Срок действия: %s, Стоимость: %.2f, Номер: %s]", validity, cost, number);
        }
    }

    private static final String DEFAULT = "default";

    private String brand = DEFAULT;
    private String model = DEFAULT;
    private double engineVolume = 1.5;
    private String color = "белый";
    private int year = 2000;
    private String country = DEFAULT;
    private Transmission transmission = Transmission.UNDEFINED;
    private Body body = Body.UNDEFINED;
    private String registrationNumber = DEFAULT;
    private int numberOfSeats = 5;
    private boolean areTiresWinter;
    private Key key = Key.DEFAULT_KEY;
    private Insurance insurance;

    public Car(String brand, String model, double engineVolume, String color, int year, String country,
               Transmission transmission, Body body, String registrationNumber, int numberOfSeats, boolean areTiresWinter, Key key, Insurance insurance) {
        if (!isNullOrBlank(brand)) this.brand = brand;
        if (!isNullOrBlank(model)) this.model = model;
        if (engineVolume > 0) this.engineVolume = engineVolume;
        if (!isNullOrBlank(color)) this.color = color;
        if (year > 0) this.year = year;
        if (!isNullOrBlank(country)) this.country = country;
        if (transmission != null) this.transmission = transmission;
        if (body != null) this.body = body;
        if (registrationNumber != null && checkRegistrationNumber(registrationNumber)) this.registrationNumber = registrationNumber;
        if (numberOfSeats > 0) this.numberOfSeats = numberOfSeats;
        this.areTiresWinter = areTiresWinter;
        if (key != null) this.key = key;
        this.insurance = insurance;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Body getBody() {
        return body;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
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

    public void setColor(String color) {
        this.color = color;
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
        return pattern.matcher(registrationNumber).matches();
    }

    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("----------\n%s %s\nГод выпуска: %d\nCборка: %s\nЦвет: %s\n" +
                        "Объем двигателя: %.1f л.\nПосадочных мест: %d\nРезина: %s\n",
                brand, model, year, country, color, engineVolume, numberOfSeats, areTiresWinter ? "Зимняя" : "Летняя"));
        if (transmission != null) stringBuilder.append("Коробка передач: ").append(transmission).append('\n');
        if (body != null) stringBuilder.append("Тип кузова: ").append(body).append('\n');
        if (registrationNumber != DEFAULT) stringBuilder.append("Регистрационный номер: ").append(registrationNumber).append('\n');
        if (key != Key.DEFAULT_KEY) stringBuilder.append(key).append('\n');
        stringBuilder.append("Страховка: ");
        if (insurance != null && insurance.checkValidity()) {
            stringBuilder.append("да ").append(insurance);
        } else if (insurance != null && !insurance.checkValidity()) {
            stringBuilder.append("просрочена ").append(insurance);
        } else {
            stringBuilder.append("нет");
        }
        stringBuilder.append("\n----------");
        return stringBuilder.toString();
    }
}
