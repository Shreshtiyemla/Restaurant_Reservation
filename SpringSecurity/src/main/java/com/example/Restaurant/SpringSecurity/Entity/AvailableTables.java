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
public class AvailableTables {
    @Id
    private int tableId;
    private int capacity;
    private boolean isAvailable;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_Id")
    private Restaurant restaurant;

    @ManyToOne
    private Customer customerBooking;

    @OneToMany(mappedBy = "tableReserving")
    private List<Reservation> reservingtables;

    @OneToMany(mappedBy = "slotForTable")
    private List<Slot> tableSlots;


    @Override
    public String toString() {
        return "AvailableTables{" +
                "tableId=" + tableId +
                ", capacity=" + capacity +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }


}
