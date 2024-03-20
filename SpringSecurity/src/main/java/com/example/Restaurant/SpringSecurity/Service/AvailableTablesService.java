package com.example.Restaurant.SpringSecurity.Service;

import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;

import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import com.example.Restaurant.SpringSecurity.Model.AvailableTablesModel;
import com.example.Restaurant.SpringSecurity.Repository.AvailableTablesRepository;
import com.example.Restaurant.SpringSecurity.Repository.ReservationRepository;
import com.example.Restaurant.SpringSecurity.Repository.RestaurantRepository;
import com.example.Restaurant.SpringSecurity.ServiceImpl.AvailableTablesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableTablesService implements AvailableTablesServiceImpl {

    @Autowired
    RestaurantRepository restaurantRepo;

    @Autowired
    AvailableTablesRepository tableRepo;

    @Autowired
    ReservationRepository reservationRepo;
    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;

    public AvailableTablesModel addTable(int restaurantId,AvailableTablesModel availableTablesModel){
        Restaurant restaurant = restaurantRepo.getReferenceById(restaurantId);
        AvailableTables availableTables = tableRepo.findById(availableTablesModel.getTableId()).orElse(null);
        if(availableTables!=null){
            return null;
        }
        AvailableTables availableTables1 = entityConverter.modelToEntityTables(availableTablesModel);
        availableTables1.setRestaurant(restaurant);
        tableRepo.save(availableTables1);
        return availableTablesModel;
    }
    public ArrayList<AvailableTablesModel> getRestaurantTables(int restaurantId){
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElse(null);
        ArrayList<AvailableTablesModel> availableTablesList = new ArrayList<>();
        if(restaurant!=null){
            List<AvailableTables> availableTables = restaurant.getTablesList();
            availableTables.forEach(table->{
                AvailableTablesModel availableTablesModel = modelConverter.entityToModelTables(table);
                availableTablesList.add(availableTablesModel);
            });
        }
        return availableTablesList;
    }
}
