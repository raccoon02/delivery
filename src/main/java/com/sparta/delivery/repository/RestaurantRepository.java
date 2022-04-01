package com.sparta.delivery.repository;

import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> { }
