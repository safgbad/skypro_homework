package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface RecipesService {
    int addRecipe(Recipe recipe);
    Recipe getRecipe(int number);
    List<Recipe> getAllRecipes(long page, long numberOfRecipesOnPage);

    Path generateFormattedFile() throws IOException;

    List<Recipe> searchByIngredientIds(List<Integer> ingredientIds);
    Recipe updateRecipe(int number, Recipe recipe);
    Recipe deleteRecipe(int number);

    void saveToFile();

    void readFromFile();
}
