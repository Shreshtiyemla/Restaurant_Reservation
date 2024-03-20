package com.example.Restaurant.SpringSecurity.Repository;


import com.example.Restaurant.SpringSecurity.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
//    Owner findByUsernameAndPassword(String username, String password);

    Owner findByUsername(String username);

//    boolean existsByUsername(String username);
}
