package com.example.Restaurant.SpringSecurity.Repository;

import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.RewardPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardPointsRepository extends JpaRepository<RewardPoints,Integer> {
    List<RewardPoints> findByCustomerReward(Customer customerReward);
}
