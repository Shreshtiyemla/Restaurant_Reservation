package com.example.Restaurant.SpringSecurity.Model;

import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Reservation;
import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import com.example.Restaurant.SpringSecurity.Entity.Slot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableTablesModel {
    private int tableId;
    private int capacity;
    private boolean isAvailable;
    private double price;

    private Restaurant restaurant;

    private Customer customerBooking;

    private List<Reservation> reservingtables;

    private List<Slot> tableSlots;

    @Override
    public String toString() {
        return "AvailableTablesModel{" +
                "tableId=" + tableId +
                ", capacity=" + capacity +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}
