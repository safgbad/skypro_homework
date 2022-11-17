package sky.pro.java.course2.hw13;

import java.util.Objects;

public class Flower {
    private String name = "Название цветка не указано";
    private String flowerColor = "белый";
    private String country = "Россия";
    private double cost = 1;
    private int lifeSpan = 3;

    public Flower(String name, String flowerColor, String country, double cost) {
        if (!isNullOrBlank(name)) this.name = name;
        if (!isNullOrBlank(flowerColor)) this.flowerColor = flowerColor;
        if (!isNullOrBlank(country)) this.country = country;
        if (cost > 0) this.cost = roundCost(cost);
    }

    public Flower(String name, String flowerColor, String country, double cost, int lifeSpan) {
        this(name, flowerColor, country, cost);
        if (lifeSpan > 0) this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public String getCountry() {
        return country;
    }

    public double getCost() {
        return cost;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setName(String name) {
        if (isNullOrBlank(name)) this.name = name;
    }

    public void setFlowerColor(String flowerColor) {
        if (isNullOrBlank(flowerColor)) this.flowerColor = flowerColor;
    }

    public void setCountry(String country) {
        if (isNullOrBlank(country)) this.country = country;
    }

    public void setCost(double cost) {
        if (cost > 0) this.cost = roundCost(cost);
    }

    public void setLifeSpan(int lifeSpan) {
        if (lifeSpan > 0) this.lifeSpan = lifeSpan;
    }

    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private double roundCost(double cost) {
        return Math.floor(100 * cost) == Math.round(100 * cost) ? (double) Math.round(100 * cost) / 100 : Math.ceil(cost * 100) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.cost, cost) == 0 && lifeSpan == flower.lifeSpan && name.equals(flower.name) && flowerColor.equals(flower.flowerColor) && country.equals(flower.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flowerColor, country, cost, lifeSpan);
    }

    @Override
    public String toString() {
        return String.format("%s – Цвет: %s; Страна происхождения: %s; Простоит дней: %d; Стоимость: %.2fRUB",
                name, flowerColor, country, lifeSpan, cost);
    }
}
