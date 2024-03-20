package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Model.AvailableTablesModel;
import com.example.Restaurant.SpringSecurity.Service.AvailableTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface AvailableTablesServiceImpl{
    public AvailableTablesModel addTable(int restaurantId, AvailableTablesModel availableTablesModel);
    public ArrayList<AvailableTablesModel> getRestaurantTables(int restaurantId);

}
