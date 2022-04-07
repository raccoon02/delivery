package com.sparta.delivery.service;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public FoodService(
            FoodRepository foodRepository,
            RestaurantRepository restaurantRepository
    ){
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public void createFood(Long restaurantId, List<FoodRequestDto> foodRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElse(null);
        if (restaurant == null){
            throw  new NullPointerException("해당 음식점이 없습니다.");
        }
        for (FoodRequestDto requestDto : foodRequestDto){
            Optional<Food> found = foodRepository.findFoodByRestaurantAndName(restaurant, requestDto.getName());
            if (found.isPresent()) {
                throw new IllegalArgumentException("해당 음식이 이미 등록되어있습니다.");
            } else if (requestDto.getPrice() > 1000000 || requestDto.getPrice() <100){
                throw new IllegalArgumentException("음식값은 100원 부터 1,000,000원까지 설정 가능합니다.");
            } else if (requestDto.getPrice() % 100 != 0 ){
                throw new IllegalArgumentException("100원 단위로만 입력 할 수 있습니다.");
            } else {
                Food food = new Food(requestDto,restaurant);
                foodRepository.save(food);
            }
        }
    }
}