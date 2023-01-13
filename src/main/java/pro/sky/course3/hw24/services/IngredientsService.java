package pro.sky.course3.hw24.services;

import pro.sky.course3.hw24.model.Ingredient;

public interface IngredientsService {
    int addIngredient(Ingredient ingredient);
    Ingredient getIngredient(int number);
}
