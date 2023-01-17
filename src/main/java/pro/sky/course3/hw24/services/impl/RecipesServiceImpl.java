package pro.sky.course3.hw24.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.model.Recipe;
import pro.sky.course3.hw24.services.RecipesService;

import java.util.*;

import static pro.sky.course3.hw24.util.Utils.addNewIngredients;

@Service
public class RecipesServiceImpl implements RecipesService {
    private static final Map<Integer, Recipe> recipes = new LinkedHashMap<>();

    @Override
    public int addRecipe(Recipe recipe) {
        for (Recipe rcp : recipes.values()) {
            if (rcp.equals(recipe)) {
                return rcp.getId();
            }
        }
        addNewIngredients(recipe);
        recipes.put(recipe.getId(), recipe);

        return recipe.getId();
    }

    @Override
    public Recipe getRecipe(int number) {
        return recipes.get(number);
    }

    @Override
    public Recipe updateRecipe(int number, Recipe recipe) {
        if (!recipes.containsKey(number)) return null;
        addNewIngredients(recipe);

        return recipes.put(number, recipe);
    }

    @Override
    public Recipe deleteRecipe(int number) {
        return recipes.remove(number);
    }

    @Override
    public List<Recipe> getAllRecipes(long page, long numberOfRecipesOnPage) {
        return recipes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .skip((page - 1) * numberOfRecipesOnPage)
                .limit(numberOfRecipesOnPage)
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    public List<Recipe> searchByIngredientIds(List<Integer> ingredientIds) {
        return recipes.values().stream()
                .filter(recipe -> new HashSet<>(recipe.getIngredients().stream()
                            .map(Ingredient::getId)
                            .toList())
                        .containsAll(ingredientIds))
                .sorted(Comparator.comparing(Recipe::getId))
                .toList();
    }
}
