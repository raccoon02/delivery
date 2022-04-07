package com.sparta.delivery.dto;


import com.sparta.delivery.model.OrderFoods;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderRequestDto {
    public Long restaurantId;
    private List<OrderFoods> foods;
}
