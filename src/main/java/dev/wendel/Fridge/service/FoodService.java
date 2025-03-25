package dev.wendel.Fridge.service;

import dev.wendel.Fridge.repository.FoodRepository;
import dev.wendel.Fridge.model.Food;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wendel
 */
@Service
public class FoodService {
    
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    
    public List<Food> getAll() {return foodRepository.findAll();}
    public Food save(Food food) {return foodRepository.save(food);}
    public void delete(Long id) {foodRepository.deleteById(id);}
    public void edit(Long id, Food newFood) {
        Optional<Food> optionalFood = foodRepository.findById(id);

        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setName(newFood.getName());
            food.setExpirationDate(newFood.getExpirationDate());
            food.setQuantity(newFood.getQuantity());
            foodRepository.save(food);
        } else {
            throw new RuntimeException("Food not found with id: " + id); // Exceção caso o item não seja encontrado
        }
    }
    
}
