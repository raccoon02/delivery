package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto){
        if(restaurantRequestDto.getMinOrderPrice() < 1000 || restaurantRequestDto.getMinOrderPrice() > 100000) throw new IllegalArgumentException("주문금액은 1,000원 이상 100,000원 이하입니다.");

        if(restaurantRequestDto.getDeliveryFee() < 0 || restaurantRequestDto.getDeliveryFee() > 10000) throw new IllegalArgumentException("배달비는 10,000원 이하입니다.");

        if(restaurantRequestDto.getMinOrderPrice() % 100 != 0) throw new IllegalArgumentException("주문금액은 100원 단위로 입력했주세요.");

        if(restaurantRequestDto.getDeliveryFee() % 500 != 0) throw new IllegalArgumentException("배달비는 500원 단위로 입력해주세요.");
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        return restaurantRepository.save(restaurant);
    }
    public List<Restaurant> veiwRestaurant() {
        return  restaurantRepository.findAll();
    }
}
