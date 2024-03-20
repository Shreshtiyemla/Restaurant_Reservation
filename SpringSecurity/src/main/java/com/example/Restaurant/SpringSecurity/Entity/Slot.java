package com.example.Restaurant.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slotId;
    private LocalTime slotStartTime;
    private LocalTime slotEndTime;
    private Duration slotDuration;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant OwnerRestaurant;

    @ManyToOne
    @JoinColumn(name = "tableId")
    private AvailableTables slotForTable;

    public Slot(LocalTime slotStartTime, LocalTime slotEndTime, Duration slotDuration, boolean available) {
        this.slotStartTime = slotStartTime;
        this.slotEndTime = slotEndTime;
        this.slotDuration = slotDuration;
        this.available = available;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public LocalTime getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(LocalTime slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public LocalTime getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(LocalTime slotEndTime) {
        this.slotEndTime = slotEndTime;
    }

    public Duration getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(Duration slotDuration) {
        this.slotDuration = slotDuration;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Restaurant getOwnerRestaurant() {
        return OwnerRestaurant;
    }

    public void setOwnerRestaurant(Restaurant ownerRestaurant) {
        OwnerRestaurant = ownerRestaurant;
    }

    public AvailableTables getSlotForTable() {
        return slotForTable;
    }

    public void setSlotForTable(AvailableTables slotForTable) {
        this.slotForTable = slotForTable;
    }
}
