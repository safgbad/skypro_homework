package pro.sky.course3.hw24.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.model.Recipe;
import pro.sky.course3.hw24.services.FilesService;
import pro.sky.course3.hw24.services.IngredientsService;
import pro.sky.course3.hw24.services.RecipesService;

import javax.annotation.PostConstruct;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Comparator;

import static pro.sky.course3.hw24.util.Utils.addNewIngredients;

@Service
public class RecipesServiceImpl implements RecipesService {

    private static int counter = 0;

    private Map<Integer, Recipe> recipes = new LinkedHashMap<>();

    private final FilesService filesService;
    private final IngredientsService ingredientsService;

    public RecipesServiceImpl(FilesService filesService, IngredientsService ingredientsService) {
        this.filesService = filesService;
        this.ingredientsService = ingredientsService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
        if (!recipes.isEmpty()) {
            counter = Collections.max(recipes.keySet());
        }
    }

    @Override
    public int addRecipe(Recipe recipe) {
        for (Recipe rcp : recipes.values()) {
            if (rcp.equals(recipe)) {
                return rcp.getId();
            }
        }
        recipe.setId(++counter);
        addNewIngredients(recipe, counter, ingredientsService);
        recipes.put(recipe.getId(), recipe);
        saveToFile();

        return recipe.getId();
    }

    @Override
    public Recipe getRecipe(int number) {
        return recipes.get(number);
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

    @Override
    public Recipe updateRecipe(int number, Recipe recipe) {
        if (!recipes.containsKey(number)) return null;
        addNewIngredients(recipe, counter, ingredientsService);
        recipe.setId(number);
        Recipe result = recipes.put(number, recipe);
        saveToFile();

        return result;
    }

    @Override
    public Recipe deleteRecipe(int number) {
        Recipe result = recipes.remove(number);
        if (result != null) {
            saveToFile();
        }

        return result;
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToJsonFile(json, filesService.getRecipesDataFileName());
            json = new ObjectMapper().writeValueAsString(ingredientsService.getIngredients());
            filesService.saveToJsonFile(json, filesService.getIngredientsDataFileName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromJsonFile(filesService.getRecipesDataFileName());
            if (json != null) {
                recipes = new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Integer, Recipe>>() {
                });
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
