package com.example.Restaurant.SpringSecurity.Security;


import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Owner;
import com.example.Restaurant.SpringSecurity.Repository.CustomerRepository;
import com.example.Restaurant.SpringSecurity.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    CustomerRepository customRepo;
    @Autowired
    OwnerRepository ownerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (customRepo.existsByUsername(username)) {
            Optional<Customer> customer = customRepo.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
            return customer.map(CustomerInfo::new).orElseThrow(() -> new UsernameNotFoundException("Customer not found " + username));
        }
            Optional<Owner> owner = ownerRepo.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
            return owner.map(OwnerInfo::new).orElseThrow(() -> new UsernameNotFoundException("Owner not found " + username));
    }


}
