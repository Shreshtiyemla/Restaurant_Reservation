package com.example.Restaurant.SpringSecurity.Repository;


import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    List<Restaurant> findByCategory(String category);


//    boolean findByTableId(int tableId);
}
