package com.example.Restaurant.SpringSecurity.Model;

import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Bill;
import com.example.Restaurant.SpringSecurity.Entity.Reservation;
import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private int customerId;
    private String customerName;
    private String username;
    private String password;
    private String customerEmail;
    private String Address;
    private long phoneNumber;

    private String role;

    private List<Restaurant> restaurantList;

    private List<Reservation> reservationList;

    private List<AvailableTables> availableTablesList;

    private List<Bill> billByCustomer;

}
