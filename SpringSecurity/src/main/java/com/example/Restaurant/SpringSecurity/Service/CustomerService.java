package com.example.Restaurant.SpringSecurity.Service;


import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import com.example.Restaurant.SpringSecurity.Model.CustomerModel;
import com.example.Restaurant.SpringSecurity.Model.RestaurantModel;
import com.example.Restaurant.SpringSecurity.Repository.AvailableTablesRepository;
import com.example.Restaurant.SpringSecurity.Repository.CustomerRepository;
import com.example.Restaurant.SpringSecurity.Repository.ReservationRepository;
import com.example.Restaurant.SpringSecurity.Repository.RestaurantRepository;
import com.example.Restaurant.SpringSecurity.ServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Autowired
    CustomerRepository customRepo;

    @Autowired
    RestaurantRepository restaurantRepo;

    @Autowired
    ReservationRepository reservationRepo;

    @Autowired
    AvailableTablesRepository tableRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;

    public Customer customerRegister(CustomerModel customerModel){
        Customer customer = entityConverter.ModelToEntityCustomer(customerModel);
        Customer customer1= customRepo.findById(customer.getCustomerId()).orElse(null);
        if(customer1==null){
            customer.setCustomerId(customerModel.getCustomerId());
            customer.setCustomerName(customerModel.getCustomerName());
            customer.setUsername(customerModel.getUsername());
            customer.setPassword(passwordEncoder.encode(customerModel.getPassword()));
            customer.setAddress(customerModel.getAddress());
            customer.setCustomerEmail(customerModel.getCustomerEmail());
            customer.setPhoneNumber(customerModel.getPhoneNumber());
            return customRepo.save(customer);
        }
        return null;
    }
    public CustomerModel loginCredentials(String username, String password) {
        Customer customer = customRepo.findByUsername(username);
        if (customer != null && passwordEncoder.matches(password,customer.getPassword())) {
            return modelConverter.EntityToModelCustomer(customer);
        } else {
            return null;
        }
    }

}
