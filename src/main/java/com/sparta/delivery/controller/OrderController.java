package com.sparta.delivery.controller;

import com.sparta.delivery.dto.OrderRequestDto;
import com.sparta.delivery.dto.OrdersResponseDto;
import com.sparta.delivery.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;



    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/order/request")
    public OrdersResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto){

        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrdersResponseDto> showOrders() {
        return orderService.showOrders();
    }


}
