package pro.sky.course3.hw24.contollers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.course3.hw24.model.Ingredient;
import pro.sky.course3.hw24.services.IngredientsService;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addIngredient(@RequestBody Ingredient ingredient) {
        return "Object number: " + ingredientsService.addIngredient(ingredient);
    }

    @GetMapping("/get")
    public Ingredient getIngredient(@RequestParam int number) {
        return ingredientsService.getIngredient(number);
    }
}
