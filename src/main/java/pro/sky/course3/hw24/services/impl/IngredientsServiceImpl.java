package pro.sky.course3.hw24.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.services.IngredientsService;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private static int counter = 0;

    private final Map<Integer, Ingredient> ingredients = new LinkedHashMap<>();

    @Override
    public int addIngredient(Ingredient ingredient) {
        ingredients.put(++counter, ingredient);
        return counter;
    }

    @Override
    public Ingredient getIngredient(int number) {
        return ingredients.get(number);
    }
}
