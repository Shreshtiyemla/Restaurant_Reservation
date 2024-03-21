package com.example.Restaurant.SpringSecurity.Service;

import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.*;
import com.example.Restaurant.SpringSecurity.Model.BillModel;
import com.example.Restaurant.SpringSecurity.Repository.*;
import com.example.Restaurant.SpringSecurity.ServiceImpl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService implements BillServiceImpl {
    @Autowired
    AvailableTablesRepository tableRepo;
    @Autowired
    BillRepository billRepo;
    @Autowired
    ReservationRepository reservationRepo;
    @Autowired
    SlotRepository slotRepo;

    @Autowired
    CustomerRepository customRepo;
    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;

    private void generateBillForReservation(Customer customer, Reservation reservation) {
        AvailableTables table = reservation.getTableReserving();
        BigDecimal billAmount = calculateBillAmount(table.getPrice());
        if(billRepo.existsById(reservation.getReservationId())){
            System.out.println("A bill already exists for reservation ID: " + reservation.getReservationId());
        }
        else {
            Bill billEntity = new Bill();
            billEntity.setCustomerBill(customer);
            billEntity.setReservation(reservation);
            System.out.println(billEntity.getReservation().getReservationId());
            billEntity.setBillAmount(billAmount);
            billEntity.setDate(LocalDate.now());
            billEntity.setBillStatus(false);
            billRepo.save(billEntity);
        }
    }

    private BigDecimal calculateBillAmount(double tablePrice) {
        return BigDecimal.valueOf(tablePrice);
    }

    public List<BillModel> getBills(int customerId){
        Customer customer = customRepo.findById(customerId).orElse(null);
        List<BillModel> billModel = new ArrayList<>();
        if(customer!=null){
            List<Bill> bills = customer.getBillByCustomer();
            bills.forEach(bill -> {
                BillModel billModel1 = modelConverter.entityToModelBill(bill);
                billModel.add(billModel1);
            });
        }
        return billModel;
    }

    public BillModel generateABillForCustomer(int customerId, int resId) {
        Customer customer = customRepo.findById(customerId).orElse(null);
        if (customer != null) {
            Reservation reservation = reservationRepo.findById(resId).orElse(null);
            if (reservation != null) {
                generateBillForReservation(customer, reservation);
                Bill bill = billRepo.findFirstByReservation(reservation);
                if (bill != null) {
                    return modelConverter.entityToModelBill(bill);
                } else {
                    System.out.println("No bill found for the reservation");
                }
            } else {
                System.out.println("Reservation not found");
            }
        } else {
            System.out.println("Customer not found");
        }
        return null;
    }

}
