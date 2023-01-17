package pro.sky.course3.hw24.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.services.IngredientsService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    public static final Map<Integer, Ingredient> ingredients = new LinkedHashMap<>();

    @Override
    public int addIngredient(Ingredient ingredient) {
        for (Ingredient ingr : ingredients.values()) {
            if (ingr.equals(ingredient)) {
                return ingr.getId();
            }
        }
        ingredients.put(ingredient.getId(), ingredient);

        return ingredient.getId();
    }

    @Override
    public Ingredient getIngredient(int number) {
        return ingredients.get(number);
    }

    @Override
    public Ingredient updateIngredient(int number, Ingredient ingredient) {
        if (!ingredients.containsKey(number)) {
            return null;
        }

        return ingredients.put(number, ingredient);
    }

    @Override
    public Ingredient deleteIngredient(int number) {
        return ingredients.remove(number);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredients.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

}
