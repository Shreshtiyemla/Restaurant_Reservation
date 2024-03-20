package com.example.Restaurant.SpringSecurity.Service;

import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.AvailableTables;
import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Reservation;
import com.example.Restaurant.SpringSecurity.Entity.Slot;
import com.example.Restaurant.SpringSecurity.Model.ReservationModel;
import com.example.Restaurant.SpringSecurity.Repository.*;
import com.example.Restaurant.SpringSecurity.ServiceImpl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService implements ReservationServiceImpl {

    @Autowired
    AvailableTablesRepository tableRepo;
    @Autowired
    ReservationRepository reservationRepo;
    @Autowired
    RestaurantRepository restaurantRepo;
    @Autowired
    CustomerRepository customRepo;

    @Autowired
    SlotRepository slotRepo;
    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;


    public int reserveTableOfRestuarent(int customerId, int tableId, int slotId) {
        Customer customer = customRepo.findById(customerId).orElse(null);
        AvailableTables table = tableRepo.findById(tableId).orElse(null);
        Slot slot = slotRepo.findById(slotId).orElse(null);
        if (customer != null && table != null && slot != null) {
            Reservation reserve = new Reservation();
            reserve.setTableReserving(table);
            reserve.setCustomerReserving(customer);
            //slot.setAvailable(false);
            reserve.setSlot(slot);
            Reservation savedReservation = reservationRepo.save(reserve);
            return savedReservation.getReservationId();
        } else {
            return -1;
        }
    }
    public List<Reservation> getBookedSlotsForCustomer(int customerId) {
        return reservationRepo.findAll().stream()
                .filter(reservation -> reservation.getCustomerReserving() != null
                        && reservation.getCustomerReserving().getCustomerId() == customerId)
                .collect(Collectors.toList());
    }
    public String cancelReservation(int reservationId, int slotId) {
        Reservation reservation = reservationRepo.findById(reservationId).orElse(null);
        Slot slot = slotRepo.findById(slotId).orElse(null);
        if (reservation != null && slot != null) {
            reservationRepo.delete(reservation);
            slot.setAvailable(true);
            slotRepo.save(slot);
            return "Reservation with ID " + reservationId + " is cancelled successfully.";
        } else {
            return "Reservation or slot does not exist.";
        }
    }
}












