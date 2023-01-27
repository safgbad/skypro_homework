package pro.sky.course3.hw24.util;

import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.model.Recipe;
import pro.sky.course3.hw24.services.impl.IngredientsServiceImpl;

import java.util.Collection;
import java.util.Collections;

public class Utils {
    public static void addNewIngredients(Recipe recipe, Integer counter) {
        Collection<Ingredient> ingredients = IngredientsServiceImpl.ingredients.values();
        label:
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            for (Ingredient ingredient : ingredients) {
                if (recipe.getIngredients().get(i).equals(ingredient)) {
                    recipe.getIngredients().add(ingredient);
                    Collections.swap(recipe.getIngredients(), i, recipe.getIngredients().size() - 1);
                    recipe.getIngredients().remove(recipe.getIngredients().size() - 1);
                    continue label;
                }
            }
            recipe.getIngredients().get(i).setId(++counter);
            IngredientsServiceImpl.ingredients.put(
                    recipe.getIngredients().get(i).getId(),
                    recipe.getIngredients().get(i));
        }
    }
}
