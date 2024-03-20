package com.example.Restaurant.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RewardPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rewardId;

    private int points;
    private LocalDate earnedDate;
    private LocalDate expiryDate;
    private boolean status;

    @OneToOne
    @JoinColumn(name = "billId")
    private Bill rewardByBill;

    @ManyToOne
    @JoinColumn(name = "customerRewardId")
    private Customer customerReward;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant rewardByRestaurant;
}
