package com.example.Restaurant.SpringSecurity.Service;

import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.*;
import com.example.Restaurant.SpringSecurity.Model.ReservationModel;
import com.example.Restaurant.SpringSecurity.Repository.*;
import com.example.Restaurant.SpringSecurity.ServiceImpl.RewardPointsServiceImpl;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RewardPointsService implements RewardPointsServiceImpl {
    @Autowired
    CustomerRepository customRepo;
    @Autowired
    SlotRepository slotRepo;
    @Autowired
    AvailableTablesRepository tableRepo;
    @Autowired
    ReservationRepository reservationRepo;
    @Autowired
    RewardPointsRepository rewardRepo;
    @Autowired
    RestaurantRepository restaurantRepo;
    @Autowired
    BillRepository billRepo;
    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;

    private static final double POINTS_PER_DOLLAR = 0.01;

    private int generateRewardPoints(double tablePrice) {
        int rewardPoints = (int) (tablePrice * POINTS_PER_DOLLAR);
        return rewardPoints;
    }

    private void saveRewardPoints(int customerId, int rewardPoints, int billId) {
        Customer customer = customRepo.findById(customerId).orElse(null);
        LocalDate earnedDate = LocalDate.now();
        LocalDate expiryDate = earnedDate.plusMonths(1);
        RewardPoints rewardPointsEntry = new RewardPoints();
        rewardPointsEntry.setCustomerReward(customer);
        rewardPointsEntry.setPoints(rewardPoints);
        rewardPointsEntry.setEarnedDate(earnedDate);
        rewardPointsEntry.setExpiryDate(expiryDate);
        Bill bill = billRepo.findById(billId).get();
        rewardPointsEntry.setRewardByBill(bill);
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(expiryDate)) {
            rewardPointsEntry.setStatus(false);
        } else {
            rewardPointsEntry.setStatus(true);
        }
        rewardRepo.save(rewardPointsEntry);
    }
    public int getRewardPointsOfCustomer(int tableId, int customerId) {
        List<RewardPoints> savedRewardPoints = rewardRepo.findAll();
        AvailableTables table=tableRepo.findById(tableId).orElse(null);
        int totalRewardPoints = savedRewardPoints.stream().filter(rewardPoints ->
            rewardPoints.getRewardByBill().getReservation().getTableReserving().getRestaurant()==table.getRestaurant()&&rewardPoints.getCustomerReward().getCustomerId()==customerId)
                .mapToInt(RewardPoints::getPoints)
                .sum();
        System.out.println("getRewardPointsOfCustomer"+ totalRewardPoints);
        return totalRewardPoints;
    }

    public Double calaculateDiscountPrice(int rewardPoints, double tablePrice) {
        double discount=tablePrice*rewardPoints*POINTS_PER_DOLLAR;
        return  (tablePrice) - discount;
    }

    public int paymentWithRewardPoints(int customerId, double billAmount, double tablePrice,int billId, String applyRewardPoints,int slotId) {
        int rewardPoints=generateRewardPoints(tablePrice);
        Bill bill=billRepo.findById(billId).orElse(null);
        AvailableTables tables=bill.getReservation().getTableReserving();
        bill.setBillAmount(BigDecimal.valueOf(billAmount));
        bill.setBillStatus(true);
        billRepo.save(bill);
        Slot slot = slotRepo.findById(slotId).orElse(null);
        slot.setAvailable(false);
        slotRepo.save(slot);
        System.out.println("applyRewardPoints "+applyRewardPoints);
        if(applyRewardPoints.equals("no")){
            assert bill != null;
            saveRewardPoints(customerId,rewardPoints,billId);
            int updatedRewardPoints=getRewardPointsOfCustomer(tables.getTableId(),customerId);
            System.out.println("after rewardPoints "+updatedRewardPoints);
            return updatedRewardPoints;
        }
        updateRewardPointsOfCustomer(customerId,tables);
        saveRewardPoints(customerId,rewardPoints,billId);
        return rewardPoints;
    }
    private void updateRewardPointsOfCustomer(int customerId, AvailableTables tables) {
        List<RewardPoints> savedRewardPoints = rewardRepo.findAll();
        savedRewardPoints.forEach(rewardPoints -> {
          if(rewardPoints.getCustomerReward().getCustomerId()==customerId&&rewardPoints.getRewardByBill().getReservation().getTableReserving().getRestaurant()==tables.getRestaurant()){
              rewardPoints.setPoints(0);
              rewardRepo.save(rewardPoints);
          }
      });
    }
}
