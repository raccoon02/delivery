package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany
    @JoinColumn(name = "ORDERS_ID")
    private List<OrderFoods> orderFoods;

    @Column(nullable = false)
    private  int totalPrice;

    @Column
    private  int deliveryFee;

    public Orders(String restaurantName, List<OrderFoods> orderFoods, int totalPrice, int deliveryFee){
        this.restaurantName = restaurantName;
        this.totalPrice = totalPrice;
        this.orderFoods = orderFoods;
        this.deliveryFee = deliveryFee;
    }
}
