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
        this.brand = Main.checkIfBlankAndReturn(brand, this.brand);
        this.model = Main.checkIfBlankAndReturn(model, this.model);
        this.engineVolume = engineVolume > 0 ? engineVolume : this.engineVolume;
        this.color = Main.checkIfBlankAndReturn(color, this.color);
        this.year = year > 0 ? year : this.year;
        this.country = Main.checkIfBlankAndReturn(country, this.country);
    }



    @Override
    public String toString() {
        return String.format("%s %s, %d год выпуска, сборка – %s, %s цвет, объем двигателя — %.1f л.",
                brand, model, year, country, color, engineVolume);
    }
}
