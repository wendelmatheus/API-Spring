package dev.wendel.Fridge.controller;

import dev.wendel.Fridge.service.FoodService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.wendel.Fridge.model.Food;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Wendel
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    
    @GetMapping
    public List<Food> getAll() {return foodService.getAll();}
    
    @PostMapping
    public Food save(@RequestBody Food food) {return foodService.save(food);}
    
    @DeleteMapping
    public void delete(Long id) {foodService.delete(id);}
    
    @PutMapping
    public void edit(@RequestParam Long id, @RequestBody Food newFood) {
        foodService.edit(id, newFood);
    }
}
