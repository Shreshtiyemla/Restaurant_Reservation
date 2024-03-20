package com.example.Restaurant.SpringSecurity.Model;

import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Bill;
import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Slot;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationModel {
    private int reservationId;

    private Customer customerReserving;

    private Bill bill;

    private AvailableTables tableReserving;

    private Slot slot;
}
