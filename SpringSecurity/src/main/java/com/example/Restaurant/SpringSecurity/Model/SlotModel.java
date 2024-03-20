package com.example.Restaurant.SpringSecurity.Model;


import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SlotModel {
    private int slotId;
    private LocalTime slotStartTime;
    private LocalTime slotEndTime;
    private boolean available;
    private Duration slotDuration;

    private Restaurant OwnerRestaurant;

    private AvailableTables slotForTable;
}
