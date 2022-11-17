package sky.pro.java.course2.hw13;

public class Car {
    private static final String DEFAULT = "default";

    private String brand = DEFAULT;
    private String model = DEFAULT;
    private double engineVolume = 1.5;
    private String color = "белый";
    private int year = 2000;
    private String country = DEFAULT;

    public Car(String brand, String model, double engineVolume, String color, int year, String country) {
        if (!isNullOrBlank(brand)) this.brand = brand;
        if (!isNullOrBlank(model)) this.model = model;
        if (engineVolume > 0) this.engineVolume = engineVolume;
        if (!isNullOrBlank(color)) this.color = color;
        if (year > 0) this.year = year;
        if (!isNullOrBlank(country)) this.country = country;
    }

    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d год выпуска, сборка – %s, %s цвет, объем двигателя — %.1f л.",
                brand, model, year, country, color, engineVolume);
    }
}
