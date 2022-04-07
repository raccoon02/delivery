package com.sparta.delivery.repository;

import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findFoodByRestaurantAndName(Restaurant restaurant, String name);
    List<Food> findByRestaurant_Id(Long restaurantId);
}
