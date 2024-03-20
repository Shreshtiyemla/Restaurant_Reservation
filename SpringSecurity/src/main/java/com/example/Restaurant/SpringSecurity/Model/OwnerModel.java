package com.example.Restaurant.SpringSecurity.Model;

import com.example.Restaurant.SpringSecurity.Entity.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OwnerModel {
    private int ownerId;
    private String ownerName;
    private String username;
    private String password;
    private String email;
    private Long mobileNo;

    private String role;

    private List<Restaurant> restaurantList;

    public OwnerModel(int ownerId, String ownerName, String username, String password, String email, Long mobileNo, String role) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobileNo = mobileNo;
        this.role = role;
    }

    @Override
    public String toString() {
        return "OwnerModel{" +
                "ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                ", role='" + role + '\'' +
                '}';
    }
}
