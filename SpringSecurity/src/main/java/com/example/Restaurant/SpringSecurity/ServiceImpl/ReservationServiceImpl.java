package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Entity.Reservation;

import java.util.List;

public interface ReservationServiceImpl {
    public int reserveTableOfRestuarent(int customerId, int tableId, int slotId);
    public List<Reservation> getBookedSlotsForCustomer(int customerId);
    public String cancelReservation(int reservationId, int slotId);
}
