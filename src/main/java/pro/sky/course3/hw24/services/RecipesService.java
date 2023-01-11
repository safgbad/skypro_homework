package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.model.Recipe;

public interface RecipesService {
    int addRecipe(Recipe recipe);
    Recipe getRecipe(int number);
}
