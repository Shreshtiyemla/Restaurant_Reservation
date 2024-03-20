package com.example.Restaurant.SpringSecurity.Service;

import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Owner;
import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import com.example.Restaurant.SpringSecurity.Model.AvailableTablesModel;
import com.example.Restaurant.SpringSecurity.Model.OwnerModel;
import com.example.Restaurant.SpringSecurity.Model.RestaurantModel;
import com.example.Restaurant.SpringSecurity.Repository.CustomerRepository;
import com.example.Restaurant.SpringSecurity.Repository.OwnerRepository;
import com.example.Restaurant.SpringSecurity.Repository.RestaurantRepository;
import com.example.Restaurant.SpringSecurity.ServiceImpl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService implements RestaurantServiceImpl {
    @Autowired
    RestaurantRepository restaurantRepo;

    @Autowired
    OwnerRepository ownerRepo;

    @Autowired
    CustomerRepository customRepo;

    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;



    public RestaurantModel saveRestaurant(int ownerId,RestaurantModel restaurantModel) {
        Owner owner = ownerRepo.getReferenceById(ownerId);
        Restaurant restaurant = restaurantRepo.findById(restaurantModel.getRestaurantId()).orElse(null);
        if(restaurant!=null){
            System.out.println("null");
            return null;
        }
        Restaurant restaurant1 = entityConverter.modelToEntityRestaurant(restaurantModel);
        restaurant1.setOwner(owner);
        restaurantRepo.save(restaurant1);
        System.out.println("Not null");
        return restaurantModel;
    }
    public ArrayList<RestaurantModel> getAllRestaurants(RestaurantModel restaurantModel){
        List<Restaurant> restaurantList = restaurantRepo.findAll();
        ArrayList<RestaurantModel> restaurantModelsList = new ArrayList<>();
        restaurantList.forEach(restaurant -> {
            RestaurantModel restaurant1 = modelConverter.entityToModelRestaurant(restaurant);
            restaurantModelsList.add(restaurant1);
        });
        return restaurantModelsList;
    }
    public ArrayList<RestaurantModel> getOwnerRestaurants(int ownerId) {
        Owner owner = ownerRepo.findById(ownerId).orElse(null);
        ArrayList<RestaurantModel> restaurantList = new ArrayList<>();
        if (owner != null) {
            List<Restaurant> restaurants = owner.getRestaurantList();
            restaurants.forEach(restaurant -> {
                RestaurantModel restaurantModel = modelConverter.entityToModelRestaurant(restaurant);
                restaurantList.add(restaurantModel);
            });
        }
        return restaurantList;
    }
    public ArrayList<RestaurantModel> getRestaurantsByCategory(String category){
        List<Restaurant> restaurantList = restaurantRepo.findByCategory(category);
        ArrayList<RestaurantModel> restaurantModelList = new ArrayList<>();
        restaurantList.forEach(restaurant -> {
            RestaurantModel restaurantModel = modelConverter.entityToModelRestaurant(restaurant);
            restaurantModelList.add(restaurantModel);
        });
        return restaurantModelList;
    }

}
