package com.example.Restaurant.SpringSecurity.Conversions;


import com.example.Restaurant.SpringSecurity.Entity.*;
import com.example.Restaurant.SpringSecurity.Model.*;
import org.springframework.stereotype.Component;

@Component
public class EntityToModelConversion {
    public OwnerModel entityToModel(Owner owner){
        if(owner == null){
            return null;
        }
        else{
            OwnerModel ownerModel = new OwnerModel();
            ownerModel.setOwnerId(owner.getOwnerId());
            ownerModel.setOwnerName(owner.getOwnerName());
            ownerModel.setUsername(owner.getUsername());
            ownerModel.setPassword(owner.getPassword());
            ownerModel.setEmail(owner.getEmail());
            ownerModel.setMobileNo(owner.getMobileNo());
            ownerModel.setRestaurantList(owner.getRestaurantList());
            return ownerModel;
        }
    }
    public CustomerModel EntityToModelCustomer(Customer customer){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId(customer.getCustomerId());
        customerModel.setCustomerName(customer.getCustomerName());
        customerModel.setUsername(customer.getUsername());
        customerModel.setPassword(customer.getPassword());
        customerModel.setAddress(customer.getAddress());
        customerModel.setCustomerEmail(customer.getCustomerEmail());
        customerModel.setPhoneNumber(customer.getPhoneNumber());
        return customerModel;
    }
    public RestaurantModel entityToModelRestaurant(Restaurant restaurant){
        if(restaurant == null){
            return null;
        }
        else{
            RestaurantModel restaurantModel = new RestaurantModel();
            restaurantModel.setRestaurantId(restaurant.getRestaurantId());
            restaurantModel.setRestaurantName(restaurant.getRestaurantName());
            restaurantModel.setCategory(restaurant.getCategory());
            restaurantModel.setAddress(restaurant.getAddress());
            restaurantModel.setPhoneNo(restaurant.getPhoneNo());
            restaurantModel.setOpeningHours(restaurant.getOpeningHours());
            restaurantModel.setClosingHours(restaurant.getClosingHours());
            restaurantModel.setOwner(restaurant.getOwner());
            return restaurantModel;
        }
    }
    public AvailableTablesModel entityToModelTables(AvailableTables availableTables){
        AvailableTablesModel availableTablesModel= new AvailableTablesModel();
        availableTablesModel.setTableId(availableTables.getTableId());
        availableTablesModel.setCapacity(availableTables.getCapacity());
        availableTablesModel.setPrice(availableTables.getPrice());
        availableTablesModel.setAvailable(availableTables.isAvailable());
        availableTablesModel.setRestaurant(availableTables.getRestaurant());
        return availableTablesModel;
    }
    public BillModel entityToModelBill(Bill bill) {
        if (bill == null) {
            return null;
        } else {
            System.out.println(bill.isBillStatus());
            BillModel billModel = new BillModel();
            billModel.setBillId(bill.getBillId());
            billModel.setBillAmount(bill.getBillAmount());
            billModel.setDate(bill.getDate());
            billModel.setReservation(bill.getReservation());
            billModel.setCustomerBill(bill.getCustomerBill());
            billModel.setBillStatus(bill.isBillStatus());
            billModel.setRewardPoints(bill.getRewardPoints());
            return billModel;
        }
    }
    public SlotModel entityToModelSlot(Slot slot){
        if(slot == null){
            return null;
        }
        else{
            SlotModel slotModel = new SlotModel();
            slotModel.setSlotId(slot.getSlotId());
            slotModel.setSlotStartTime(slot.getSlotStartTime());
            slotModel.setSlotEndTime(slot.getSlotEndTime());
            slotModel.setSlotDuration(slot.getSlotDuration());
            slotModel.setSlotForTable(slot.getSlotForTable());
            slotModel.setAvailable(slot.isAvailable());
            slotModel.setOwnerRestaurant(slot.getOwnerRestaurant());
            return slotModel;
        }
    }
    public ReservationModel entityToModelReservation(Reservation reservation){
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setReservationId(reservation.getReservationId());
        reservationModel.setTableReserving(reservation.getTableReserving());
        reservationModel.setCustomerReserving(reservation.getCustomerReserving());
        reservationModel.setSlot(reservation.getSlot());
        reservationModel.setBill(reservation.getBill());
        return  reservationModel;
    }
}
