package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Model.RestaurantModel;

import java.util.ArrayList;

public interface RestaurantServiceImpl {
    public RestaurantModel saveRestaurant(int ownerId, RestaurantModel restaurantModel);
    public ArrayList<RestaurantModel> getAllRestaurants(RestaurantModel restaurantModel);
    public ArrayList<RestaurantModel> getOwnerRestaurants(int ownerId);
    public ArrayList<RestaurantModel> getRestaurantsByCategory(String category);
}
