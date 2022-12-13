package sky.pro.java.course2.hw20.products;

import java.util.ArrayList;

public class RecipeBook {
    private final ArrayList<Recipe> recipes;

    public RecipeBook() {
        recipes = new ArrayList<>();
    }

    public Recipe getReceipt(String receiptName) {
        int index = recipes.indexOf(new Recipe(receiptName));
        if (index >= 0) {
            return recipes.get(index);
        }
        return null;
    }

    public void addReceipt(Recipe recipe) {
        if (recipes.contains(recipe)) {
            throw new IllegalArgumentException("В книге уже есть такой рецепт!");
        }
        recipes.add(recipe);
    }

    public boolean removeReceipt(String receiptName) {
        return recipes.remove(new Recipe(receiptName));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Книга рецептов\n========================================");
        for (Recipe recipe : recipes) {
            stringBuilder.append('\n').append(recipe).append('\n');
        }
        stringBuilder.append('\n').append("========================================");
        return stringBuilder.toString();
    }
}
