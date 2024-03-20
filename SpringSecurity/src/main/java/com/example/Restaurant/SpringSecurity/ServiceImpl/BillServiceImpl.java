package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Reservation;
import com.example.Restaurant.SpringSecurity.Model.BillModel;

import java.util.List;

public interface BillServiceImpl {
    public List<BillModel> getBills(int customerId);

    public BillModel generateABillForCustomer(int customerId, int resId);
}
