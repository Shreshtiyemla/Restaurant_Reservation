package com.example.Restaurant.SpringSecurity.ServiceImpl;

import com.example.Restaurant.SpringSecurity.Entity.Owner;
import com.example.Restaurant.SpringSecurity.Model.OwnerModel;
import com.example.Restaurant.SpringSecurity.Model.ReservationModel;

import java.util.List;

public interface OwnerServiceImpl {
    public Owner registerOwner(OwnerModel ownerModel);
    public OwnerModel loginOwner(String username,String password);
    public List<ReservationModel> getAllReservations(int ownerId);

}
