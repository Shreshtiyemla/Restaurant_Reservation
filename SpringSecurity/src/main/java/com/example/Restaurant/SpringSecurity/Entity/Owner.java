package com.example.Restaurant.SpringSecurity.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Owner {
    @Id
    private int ownerId;
    private String ownerName;
    private String username;
    private String password;
    private String email;
    private Long mobileNo;

    private String role;

    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<Restaurant> restaurantList;

    public Owner(int ownerId, String ownerName, String username, String password, String email, Long mobileNo, String role) {
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
        return "Owner{" +
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
