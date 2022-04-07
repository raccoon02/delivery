package com.sparta.delivery.repository;


import com.sparta.delivery.model.OrderFoods;
import com.sparta.delivery.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFoodsRepository extends JpaRepository<OrderFoods,Long> {
    List<OrderFoods> findOlderFoodsByOrders(Orders orders);
}
