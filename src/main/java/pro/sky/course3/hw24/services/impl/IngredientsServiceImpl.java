package pro.sky.course3.hw24.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import pro.sky.course3.hw24.exceptions.UnableToConvertToJson;
import pro.sky.course3.hw24.exceptions.UnableToParseJson;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.services.FilesService;
import pro.sky.course3.hw24.services.IngredientsService;

import javax.annotation.PostConstruct;
import java.nio.file.NoSuchFileException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private static Integer counter = 0;

    public LinkedHashMap<Integer, Ingredient> ingredients = new LinkedHashMap<>();

    private final FilesService filesService;

    public IngredientsServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @Override
    public Map<Integer, Ingredient> getIngredients() {
        return ingredients;
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
    public int addIngredient(Ingredient ingredient) {
        for (Ingredient ingr : ingredients.values()) {
            if (ingr.equals(ingredient)) {
                return ingr.getId();
            }
        }
        ingredient.setId(++counter);
        ingredients.put(ingredient.getId(), ingredient);
        saveToFile();

        return ingredient.getId();
    }

    @Override
    public Ingredient getIngredient(int number) {
        return ingredients.get(number);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredients.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    public Ingredient updateIngredient(int number, Ingredient ingredient) {
        if (!ingredients.containsKey(number)) {
            return null;
        }
        ingredient.setId(number);
        Ingredient result = ingredients.put(number, ingredient);
        saveToFile();

        return result;
    }

    @Override
    public Ingredient deleteIngredient(int number) {
        Ingredient result = ingredients.remove(number);
        if (result != null) {
            saveToFile();
        }

        return result;
    }

    @Override
    public void saveToFile() throws UnableToConvertToJson {
        try {
            DataFile dataFile = new DataFile(counter, ingredients);
            String json = new ObjectMapper().writeValueAsString(dataFile);
            filesService.saveToJsonFile(json, filesService.getIngredientsDataFileName());
        } catch (JsonProcessingException e) {
            throw new UnableToConvertToJson(e);
        }
    }

    @Override
    public void readFromFile() throws UnableToParseJson {
        try {
            String json = filesService.readFromJsonFile(filesService.getIngredientsDataFileName());
            DataFile dataFile = new ObjectMapper().readValue(json, new TypeReference<>() {
            });
            ingredients = dataFile.getIngredients();
            counter = dataFile.getCounter();
        } catch (JsonProcessingException e) {
            throw new UnableToParseJson(e);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DataFile {
        private Integer counter;
        private LinkedHashMap<Integer, Ingredient> ingredients;
    }
}
