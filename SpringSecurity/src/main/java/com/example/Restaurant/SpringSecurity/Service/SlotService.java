package com.example.Restaurant.SpringSecurity.Service;

import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import com.example.Restaurant.SpringSecurity.Entity.Slot;
import com.example.Restaurant.SpringSecurity.Model.SlotModel;
import com.example.Restaurant.SpringSecurity.Repository.AvailableTablesRepository;
import com.example.Restaurant.SpringSecurity.Repository.RestaurantRepository;
import com.example.Restaurant.SpringSecurity.Repository.SlotRepository;
import com.example.Restaurant.SpringSecurity.ServiceImpl.SlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlotService implements SlotServiceImpl {
    @Autowired
    SlotRepository slotRepo;
    @Autowired
    RestaurantRepository restaurantRepo;

    @Autowired
    AvailableTablesRepository tableRepo;

    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;


    public void generateSlotsForTableInRestaurant(int restaurantId, int tableId) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElse(null);
        if (restaurant == null) {
            return;
        }
        AvailableTables table = tableRepo.findById(tableId).orElse(null);
        if (table == null) {
            return;
        }
        LocalTime openingHours = restaurant.getOpeningHours();
        LocalTime closingHours = restaurant.getClosingHours();
        if (openingHours == null || closingHours == null || closingHours.isBefore(openingHours)) {
            return;
        }
        Duration slotDuration = Duration.ofHours(1);
        LocalTime startTime = openingHours;
        while (startTime.plus(slotDuration).isBefore(closingHours) || !startTime.plus(slotDuration).equals(closingHours)) {
            Slot slot = new Slot();
            slot.setSlotStartTime(startTime);
            slot.setSlotEndTime(startTime.plus(slotDuration));
            slot.setSlotDuration(slotDuration);
            slot.setAvailable(true);
            slot.setSlotForTable(table);
            slotRepo.save(slot);
            startTime = startTime.plus(slotDuration);
        }
    }

    public List<SlotModel> getSlots(int tableId){
        AvailableTables availableTables = tableRepo.findById(tableId).orElse(null);
        List<SlotModel> slotModelList = new ArrayList<>();
        List<Slot> slots = availableTables.getTableSlots();
        slots.forEach(slot -> {
            SlotModel slotModel = modelConverter.entityToModelSlot(slot);
            slotModelList.add(slotModel);
        });
        return slotModelList;
    }
}
