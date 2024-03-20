package com.example.Restaurant.SpringSecurity.Model;

import java.time.LocalDate;

public class RewardPointsModel {
    private int rewardId;
    private int points;
    private LocalDate earnedDate;
    private LocalDate expiryDate;
    private boolean status;
}
