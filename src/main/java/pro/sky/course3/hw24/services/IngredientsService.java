package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.model.Ingredient;

import java.util.List;

public interface IngredientsService {
    int addIngredient(Ingredient ingredient);
    Ingredient getIngredient(int number);
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(int number, Ingredient ingredient);
    Ingredient deleteIngredient(int number);
}
