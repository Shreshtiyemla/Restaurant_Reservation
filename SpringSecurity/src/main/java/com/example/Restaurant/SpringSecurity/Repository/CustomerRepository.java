package com.example.Restaurant.SpringSecurity.Repository;


import com.example.Restaurant.SpringSecurity.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//    Customer findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    Customer findByUsername(String username);
}
