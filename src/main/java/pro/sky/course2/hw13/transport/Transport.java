package pro.sky.course2.hw13.transport;

import pro.sky.course2.hw13.Utility;

public abstract class Transport {
    public enum Fuel {
        GASOLINE("бензин"),
        DIESEL("дизель"),
        ELECTRICITY("электричество"),
        UNDEFINED("информация не указана");

        private final String VALUE;

        Fuel(String VALUE) {
            this.VALUE = VALUE;
        }

        @Override
        public String toString() {
            return VALUE;
        }
    }

    static final String DELIMITER = "----------";
    static final String DEFAULT = "default";
    static final Fuel DEFAULT_FUEL = Fuel.UNDEFINED;
    private static final String DEFAULT_COUNTRY = "Россия";
    private static final String DEFAULT_COLOR = "белый";
    private static final Integer DEFAULT_YEAR = 2000;
    private static final Double DEFAULT_MAX_SPEED = 100.0;

    private final String BRAND;
    private final String MODEL;
    private final Integer YEAR;
    private final String COUNTRY;
    private String color;
    private Double maxSpeed;
    private Fuel fuel;
    private Boolean isFueled;

    public Transport(String BRAND, String MODEL, Integer YEAR, String COUNTRY, String color, Double maxSpeed, Boolean isFueled) {
        this.BRAND = Utility.isStringNotNullOrBlank(BRAND) ? BRAND : DEFAULT;
        this.MODEL = Utility.isStringNotNullOrBlank(MODEL) ? MODEL : DEFAULT;
        this.YEAR = Utility.isNumberNotNullOrNegative(YEAR) ? YEAR : DEFAULT_YEAR;
        this.COUNTRY = Utility.isStringNotNullOrBlank(COUNTRY) ? COUNTRY : DEFAULT_COUNTRY;
        setColor(color);
        setMaxSpeed(maxSpeed);
        this.isFueled = isFueled != null ? isFueled : false;
    }

    public String getBRAND() {
        return BRAND;
    }

    public String getMODEL() {
        return MODEL;
    }

    public Integer getYEAR() {
        return YEAR;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public String getColor() {
        return color;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setColor(String color) {
        this.color = Utility.isStringNotNullOrBlank(color) ? color : DEFAULT_COLOR;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = Utility.isNumberNotNullOrNegative(maxSpeed) ? maxSpeed : DEFAULT_MAX_SPEED;
    }

    void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    // позволил себе немного видоизменить задание: теперь можно попытаться заправить транспорт любым топливом Fuel
    // при несовпадении видов топлива ничего происходить не будет
    // проверка на корректность вида топлива для каждого вида транспорт происходит в методах setFuelType
    public abstract void setFuelType(Fuel fuel);

    public boolean refill(Fuel fuel) {
        if (this.fuel == fuel && this.fuel != Fuel.UNDEFINED) {
            isFueled = true;
            return true;
        }
        else return false;
    }

    public String getStringInfo() {
        return String.format("%s %s\nГод выпуска: %d\nCборка: %s\nЦвет: %s\nМаксимальная скорость: %.2f км/ч" +
                        "\nТопливо: %s\nЗаправлен: %s",
                BRAND, MODEL, YEAR, COUNTRY, color, maxSpeed, fuel, isFueled ? "да" : "нет");
    }
}
