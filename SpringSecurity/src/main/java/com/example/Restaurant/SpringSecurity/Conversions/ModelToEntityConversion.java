package com.example.Restaurant.SpringSecurity.Conversions;


import com.example.Restaurant.SpringSecurity.Entity.*;
import com.example.Restaurant.SpringSecurity.Model.*;
import org.springframework.stereotype.Component;

@Component
public class ModelToEntityConversion {
    public Owner modelToEntity(OwnerModel ownerModel){
        if(ownerModel == null ){
            return null;
        }
        else{
            Owner owner = new Owner();
            owner.setOwnerId(ownerModel.getOwnerId());
            owner.setOwnerName(ownerModel.getOwnerName());
            owner.setUsername(ownerModel.getUsername());
            owner.setPassword(ownerModel.getPassword());
            owner.setEmail(ownerModel.getEmail());
            owner.setMobileNo(ownerModel.getMobileNo());
            owner.setRestaurantList(ownerModel.getRestaurantList());
            return owner;
        }
    }
    public Customer ModelToEntityCustomer(CustomerModel customerModel){
        Customer customer = new Customer();
        customer.setCustomerId(customerModel.getCustomerId());
        customer.setCustomerName(customerModel.getCustomerName());
        customer.setUsername(customerModel.getUsername());
        customer.setPassword(customerModel.getPassword());
        customer.setAddress(customerModel.getAddress());
        customer.setCustomerEmail(customerModel.getCustomerEmail());
        customer.setPhoneNumber(customerModel.getPhoneNumber());
        return customer;
    }
    public Restaurant modelToEntityRestaurant(RestaurantModel restaurantModel){
        if(restaurantModel == null ){
            return null;
        }
        else{
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(restaurantModel.getRestaurantId());
            restaurant.setRestaurantName(restaurantModel.getRestaurantName());
            restaurant.setCategory(restaurantModel.getCategory());
            restaurant.setAddress(restaurantModel.getAddress());
            restaurant.setPhoneNo(restaurantModel.getPhoneNo());
            restaurant.setOpeningHours(restaurantModel.getOpeningHours());
            restaurant.setClosingHours(restaurantModel.getClosingHours());
            restaurant.setOwner(restaurantModel.getOwner());
            return restaurant;
        }
    }
    public AvailableTables modelToEntityTables(AvailableTablesModel availableTablesModel){
        AvailableTables availableTables = new AvailableTables();
        availableTables.setTableId(availableTablesModel.getTableId());
        availableTables.setCapacity(availableTablesModel.getCapacity());
        availableTables.setPrice(availableTablesModel.getPrice());
        availableTables.setAvailable(availableTablesModel.isAvailable());
        availableTables.setRestaurant(availableTablesModel.getRestaurant());
        return availableTables;
    }
    public Slot modelToEntitySlot(SlotModel slotModel){
        if(slotModel == null ){
            return null;
        }
        else{
            Slot slot = new Slot();
            slot.setSlotId(slotModel.getSlotId());
            slot.setSlotStartTime(slotModel.getSlotStartTime());
            slot.setSlotEndTime(slotModel.getSlotEndTime());
            slot.setSlotDuration(slotModel.getSlotDuration());
            slot.setAvailable(slotModel.isAvailable());
            slot.setSlotForTable(slotModel.getSlotForTable());
            slot.setOwnerRestaurant(slotModel.getOwnerRestaurant());
            return slot;
        }
    }
    public Bill modelToEntityBill(BillModel billModel){
        if(billModel==null){
            return null;
        }
        else{
            Bill bill = new Bill();
            bill.setBillId(billModel.getBillId());
            bill.setBillAmount(billModel.getBillAmount());
            bill.setDate(billModel.getDate());
            bill.setReservation(billModel.getReservation());
            bill.setCustomerBill(billModel.getCustomerBill());
            bill.setBillStatus(billModel.isBillStatus());
            bill.setRewardPoints(billModel.getRewardPoints());
            return bill;
        }
    }
}
