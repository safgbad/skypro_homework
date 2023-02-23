package pro.sky.course3.hw24.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import pro.sky.course3.hw24.exceptions.UnableToConvertToJson;
import pro.sky.course3.hw24.exceptions.UnableToCreateTempFile;
import pro.sky.course3.hw24.exceptions.UnableToParseJson;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.model.Recipe;
import pro.sky.course3.hw24.services.FilesService;
import pro.sky.course3.hw24.services.IngredientsService;
import pro.sky.course3.hw24.services.RecipesService;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Comparator;

@Service
public class RecipesServiceImpl implements RecipesService {

    private static int counter = 0;

    private LinkedHashMap<Integer, Recipe> recipes = new LinkedHashMap<>();

    private final FilesService filesService;
    private final IngredientsService ingredientsService;

    public RecipesServiceImpl(FilesService filesService, IngredientsService ingredientsService) {
        this.filesService = filesService;
        this.ingredientsService = ingredientsService;
    }

    @PostConstruct
    private void init() {
        try {
            readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
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
        addNewIngredients(recipe);
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
    public Path generateFormattedFile() throws UnableToCreateTempFile, IOException {
        Path path = filesService.createTempFile("formattedRecipes");
        for (Recipe recipe : recipes.values())
        {
            try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.append("## ").append(recipe.getName()).append('\n');
                writer.append("#### ").append("*Время приготовления:* ")
                        .append(String.valueOf(recipe.getCookingTime()))
                        .append(" минут").append('\n');
                writer.append("#### *Ингредиенты:*").append('\n');
                for (Ingredient ingredient : recipe.getIngredients()) {
                    writer.append("• ").append(ingredient.getName())
                            .append(" – ").append(String.valueOf(ingredient.getAmount()))
                            .append(ingredient.getMeasureUnit()).append('\n');
                }
                writer.append("#### *Инструкция приготовления:*").append('\n');
                for (String step : recipe.getSteps()) {
                    writer.append("1. ").append(step).append("\n");
                }
                writer.append('\n');
            }
        }

        return path;
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
        addNewIngredients(recipe);
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

    public void saveToFile() {
        try {
            DataFile dataFile = new DataFile(counter, recipes);
            String json = new ObjectMapper().writeValueAsString(dataFile);
            filesService.saveToJsonFile(json, filesService.getRecipesDataFileName());
            ingredientsService.saveToFile();
        } catch (JsonProcessingException e) {
            throw new UnableToConvertToJson(e);
        }
    }

    public void readFromFile() throws UnableToParseJson {
        try {
            String json = filesService.readFromJsonFile(filesService.getRecipesDataFileName());
            DataFile dataFile = new ObjectMapper().readValue(json, new TypeReference<>() {
            });
            recipes = dataFile.getRecipes();
            counter = dataFile.getCounter();
        } catch (JsonProcessingException e) {
            throw new UnableToParseJson(e);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        }
    }

    private void addNewIngredients(Recipe recipe) {
        List<Ingredient> ingredients = recipe.getIngredients();
        label:
        for (int i = 0; i < ingredients.size(); i++) {
            for (Ingredient ingredient : ingredientsService.getIngredients().values())
            {
                if (ingredients.get(i).equals(ingredient)) {
                    ingredients.add(ingredient);
                    Collections.swap(ingredients, i, ingredients.size() - 1);
                    ingredients.remove(ingredients.size() - 1);
                    continue label;
                }
            }
            ingredientsService.addIngredient(ingredients.get(i));
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DataFile {
        private Integer counter;
        private LinkedHashMap<Integer, Recipe> recipes;
    }
}
