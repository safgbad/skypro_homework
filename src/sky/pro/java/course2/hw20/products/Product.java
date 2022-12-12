package sky.pro.java.course2.hw20.products;

import java.util.Objects;

public class Product {
    private final String name;
    private final Double price;
    private final Double neededAmount;
    private final Boolean isWeighable;
    private boolean isBought;

    public Product(String name, Double price, Double neededAmount, Boolean isWeighable) {
        this.name = name;
        this.price = price;
        this.neededAmount = neededAmount;
        this.isWeighable = isWeighable;
        isBought = false;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getNeededAmount() {
        return neededAmount;
    }

    public Boolean isWeighable() {
        return isWeighable;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s)%s",
                name,
                neededAmount + (isWeighable ? " кг" : " шт"),
                price + (isWeighable ? " руб/кг" : " руб/шт"),
                isBought ? " (КУПЛЕНО)" : "");
    }
}
