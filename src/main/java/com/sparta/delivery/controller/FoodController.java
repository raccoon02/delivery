package com.sparta.delivery.controller;


import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;
    private final FoodRepository foodRepository;


    public FoodController(FoodService foodService, FoodRepository foodRepository) {
        this.foodService = foodService;
        this.foodRepository = foodRepository;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId,
                           @RequestBody List<FoodRequestDto> foodRequestDto){
        foodService.createFood(restaurantId,foodRequestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId) {return foodRepository.findByRestaurant_Id(restaurantId);}

}
