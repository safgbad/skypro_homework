package pro.sky.course3.hw24.contollers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.course3.hw24.model.Recipe;
import pro.sky.course3.hw24.services.RecipesService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipesController {
    private static final long NUMBER_OF_RECIPES_ON_PAGE = 10;

    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok("Recipe ID: " + recipesService.addRecipe(recipe));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable int id) {
        Recipe result = recipesService.getRecipe(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        Recipe oldRecipe = recipesService.updateRecipe(id, recipe);
        if (oldRecipe == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Recipe #" + id + " has been updated");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable int id) {
        Recipe deletedRecipe = recipesService.deleteRecipe(id);
        if (deletedRecipe == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Recipe #" + id + " has been deleted");
    }

    @GetMapping
    public ResponseEntity<?> getAllRecipes(@RequestParam(defaultValue = "1") long page) {
        List<Recipe> recipes = recipesService.getAllRecipes(page, NUMBER_OF_RECIPES_ON_PAGE);
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(recipes);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByIngredientIds(@RequestBody List<Integer> ingredientIds) {
        List<Recipe> recipes = recipesService.searchByIngredientIds(ingredientIds);
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(recipes);
    }
}
