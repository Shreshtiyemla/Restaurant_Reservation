package com.example.Restaurant.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private String username;
    private String password;
    private String customerEmail;
    private String Address;
    private long phoneNumber;

    private String role;


    @ManyToMany
    @JoinTable(name = "customer_restaurant",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    private List<Restaurant> restaurantList;

    @OneToMany(mappedBy = "customerReserving")
    private List<Reservation> reservationList;

    @OneToMany(mappedBy = "customerBooking")
    private List<AvailableTables> availableTablesList;

    @OneToMany(mappedBy = "customerBill")
    private List<Bill> billByCustomer;

    @OneToMany(mappedBy = "customerReward")
    private List<RewardPoints> rewardPoints;


}
