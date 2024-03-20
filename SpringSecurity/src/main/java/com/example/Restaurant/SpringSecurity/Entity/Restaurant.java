package com.example.Restaurant.SpringSecurity.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    private int restaurantId;
    private String restaurantName;
    private String category;
    private String address;
    private long phoneNo;
    private LocalTime openingHours;
    private LocalTime closingHours;

    @OneToMany(mappedBy = "OwnerRestaurant")
    private List<Slot> slots;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ownerId")
    private Owner owner;

    @Column(insertable=false, updatable=false)
    private int ownerId;

    @OneToMany(mappedBy = "restaurant")
    private List<AvailableTables> tablesList ;

    @ManyToMany(mappedBy = "restaurantList")
    private List<Customer> customerList;

    @OneToMany(mappedBy = "rewardByRestaurant")
    private List<RewardPoints> rewardPointsByRestaurant;
    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", category='" + category + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                ", openingHours=" + openingHours +
                ", closingHours=" + closingHours +
                ", ownerId=" + ownerId +
                '}';
    }
}
