package pro.sky.course3.hw24.contollers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.services.IngredientsService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok("Ingredient ID: " + ingredientsService.addIngredient(ingredient));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getIngredient(@PathVariable int id) {
        Ingredient result = ingredientsService.getIngredient(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        Ingredient oldIngredient = ingredientsService.updateIngredient(id, ingredient);
        if (oldIngredient == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Ingredient #" + id + " has been updated");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable int id) {
        Ingredient deletedIngredient = ingredientsService.deleteIngredient(id);
        if (deletedIngredient == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Ingredient #" + id + " has been deleted");
    }

    @GetMapping
    public ResponseEntity<?> getAllIngredients() {
        List<Ingredient> ingredients = ingredientsService.getAllIngredients();
        if (ingredients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ingredients);
    }
}
