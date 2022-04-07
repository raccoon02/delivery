package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderFoods {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private  Food food;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    private Orders orders ;

    public OrderFoods(Food food, int quantity){
        this.food = food;
        this.quantity = quantity;
    }
}
