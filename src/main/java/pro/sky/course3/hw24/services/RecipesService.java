package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.model.Recipe;

import java.util.List;

public interface RecipesService {
    int addRecipe(Recipe recipe);
    Recipe getRecipe(int number);
    Recipe updateRecipe(int number, Recipe recipe);
    Recipe deleteRecipe(int number);
    List<Recipe> getAllRecipes(long page, long numberOfRecipesOnPage);
}
