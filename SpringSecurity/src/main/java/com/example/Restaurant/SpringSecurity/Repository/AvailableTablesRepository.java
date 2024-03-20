package com.example.Restaurant.SpringSecurity.Repository;

import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableTablesRepository extends JpaRepository<AvailableTables,Integer> {

//    List<AvailableTables> findByRestaurantId(int restaurantId);
}
