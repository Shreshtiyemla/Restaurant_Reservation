package com.example.Restaurant.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "customerReservingId")
    private Customer customerReserving;

    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "tableId")
    private AvailableTables tableReserving;

    @ManyToOne
    @JoinColumn(name = "slotId")
    private Slot slot;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Customer getCustomerReserving() {
        return customerReserving;
    }

    public void setCustomerReserving(Customer customerReserving) {
        this.customerReserving = customerReserving;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public AvailableTables getTableReserving() {
        return tableReserving;
    }

    public void setTableReserving(AvailableTables tableReserving) {
        this.tableReserving = tableReserving;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
