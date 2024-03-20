package com.example.Restaurant.SpringSecurity.Repository;

import com.example.Restaurant.SpringSecurity.Entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {
}
