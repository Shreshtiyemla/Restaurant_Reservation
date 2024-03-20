package com.example.Restaurant.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Bill {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int billId;
    private BigDecimal billAmount;
    private LocalDate date;
    private boolean billStatus;

    public boolean isBillStatus() {
        return billStatus;
    }

    public void setBillStatus(boolean billStatus) {
        this.billStatus = billStatus;
    }

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name="customerId1")
    private Customer customerBill;

    @OneToOne(mappedBy = "rewardByBill")

    private RewardPoints rewardPoints;


}
