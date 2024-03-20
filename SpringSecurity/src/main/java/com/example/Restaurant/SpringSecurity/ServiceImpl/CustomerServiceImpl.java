package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Model.CustomerModel;
import com.example.Restaurant.SpringSecurity.Model.RestaurantModel;

import java.util.ArrayList;

public interface CustomerServiceImpl {
    public Customer customerRegister(CustomerModel customerModel);
    public CustomerModel loginCredentials(String username, String password);

}
