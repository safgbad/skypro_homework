package sky.pro.java.course2.hw20.products;

import java.util.Objects;

public class Recipe {
    private final ProductList ingredients;
    private Double ingredientsCost;
    private final String name;

    public Recipe(String name) {
        ingredients = new ProductList();
        ingredientsCost = 0.0;
        this.name = name;
    }

    public Recipe(String name, ProductList ingredients) {
        this.ingredients = ingredients;
        ingredientsCost = ingredients.sum();
        this.name = name;
    }

    public void addIngredient(String name, Double price, Double neededWeight) {
        ingredients.addProduct(name, price, neededWeight);
        ingredientsCost = ingredients.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name);
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
