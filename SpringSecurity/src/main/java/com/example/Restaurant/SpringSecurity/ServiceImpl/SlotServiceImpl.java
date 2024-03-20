package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Model.SlotModel;

import java.util.List;

public interface SlotServiceImpl {
    public void generateSlotsForTableInRestaurant(int restaurantId, int tableId);
    public List<SlotModel> getSlots(int tableId);
}
