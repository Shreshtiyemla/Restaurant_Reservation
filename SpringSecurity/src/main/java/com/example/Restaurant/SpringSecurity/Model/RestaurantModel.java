package com.example.Restaurant.SpringSecurity.Model;


import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Owner;
import com.example.Restaurant.SpringSecurity.Entity.Slot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    private int restaurantId;
    private String restaurantName;
    private String category;
    private String address;
    private long phoneNo;
    private LocalTime openingHours;
    private LocalTime closingHours;

    private Owner owner;

    private List<Slot> slots;

    private List<AvailableTables> tablesList;

    private List<Customer> customerList;

    public RestaurantModel(int restaurantId, String restaurantName, String category, String address, long phoneNo, LocalTime openingHours, LocalTime closingHours) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.category = category;
        this.address = address;
        this.phoneNo = phoneNo;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }

    @Override
    public String toString() {
        return "RestaurantModel{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", category='" + category + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                ", openingHours=" + openingHours +
                ", closingHours=" + closingHours +
                '}';
    }
}
