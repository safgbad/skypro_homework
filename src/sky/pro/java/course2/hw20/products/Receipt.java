package sky.pro.java.course2.hw20.products;

import java.util.Objects;

public class Receipt {
    private final ProductList ingredients;
    private Double ingredientsCost;
    private final String name;

    public Receipt(String name) {
        ingredients = new ProductList();
        ingredientsCost = 0.0;
        this.name = name;
    }

    public Receipt(String name, ProductList ingredients) {
        this.ingredients = ingredients;
        ingredientsCost = ingredients.sum();
        this.name = name;
    }

    public void addIngredient(String name, Double price, Double neededWeight, Boolean isWeighable) {
        ingredients.addProduct(name, price, neededWeight, isWeighable);
        ingredientsCost = ingredients.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return name.equals(receipt.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Рецепт \"%s\" общей стоимостью %.2f рублей.\n%s",
                name, ingredientsCost, ingredients);
    }
}
