package dev.wendel.Fridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.wendel.Fridge.model.Food;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wendel
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
