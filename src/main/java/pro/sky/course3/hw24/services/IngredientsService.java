package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.model.Ingredient;

import java.util.List;
import java.util.Map;

public interface IngredientsService {
    Map<Integer, Ingredient> getIngredients();

    int addIngredient(Ingredient ingredient);
    Ingredient getIngredient(int number);
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(int number, Ingredient ingredient);
    Ingredient deleteIngredient(int number);

    void saveToFile();

    void readFromFile();
}
