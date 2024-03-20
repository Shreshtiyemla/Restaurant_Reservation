package com.example.Restaurant.SpringSecurity.Service;


import com.example.Restaurant.SpringSecurity.Conversions.EntityToModelConversion;
import com.example.Restaurant.SpringSecurity.Conversions.ModelToEntityConversion;
import com.example.Restaurant.SpringSecurity.Entity.Owner;
import com.example.Restaurant.SpringSecurity.Entity.Reservation;
import com.example.Restaurant.SpringSecurity.Model.OwnerModel;
import com.example.Restaurant.SpringSecurity.Model.ReservationModel;
import com.example.Restaurant.SpringSecurity.Repository.*;
import com.example.Restaurant.SpringSecurity.ServiceImpl.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService implements OwnerServiceImpl {
    @Autowired
    OwnerRepository ownerRepo;
    @Autowired
    RestaurantRepository restaurantRepo;
    @Autowired
    ReservationRepository reservationRepo;
    @Autowired
    CustomerRepository customRepo;
    @Autowired
    AvailableTablesRepository tableRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EntityToModelConversion modelConverter;
    @Autowired
    ModelToEntityConversion entityConverter;


    public Owner registerOwner(OwnerModel ownerModel){
        Owner owner = entityConverter.modelToEntity(ownerModel);
        Owner owner1 = ownerRepo.findById(owner.getOwnerId()).orElse(null);
        if(owner1==null){
            owner.setOwnerId(ownerModel.getOwnerId());
            owner.setOwnerName(ownerModel.getOwnerName());
            owner.setUsername(ownerModel.getUsername());
            owner.setPassword(passwordEncoder.encode(ownerModel.getPassword()));
            owner.setEmail(ownerModel.getEmail());
            owner.setMobileNo(ownerModel.getMobileNo());
            List<Owner> ownerList = ownerRepo.findAll();
            boolean userNameexists = ownerList.stream().anyMatch(ownerObj->ownerObj.getUsername().equals(ownerModel.getUsername()));
            if(userNameexists){
                return null;
            }
            else {
                return ownerRepo.save(owner);
            }
        }
        return null;
    }
    public OwnerModel loginOwner(String username,String password) {
        Owner owner = ownerRepo.findByUsername(username);
        System.out.println(owner.getUsername());
        if (owner != null && passwordEncoder.matches(password,owner.getPassword()) ){
            return modelConverter.entityToModel(owner);
        } else {
            return null;
        }
    }



    public List<ReservationModel> getAllReservations(int ownerId){
        List<Reservation> allreservations = reservationRepo.findAll();
        List<ReservationModel> ownerReservations = new ArrayList<>();
        allreservations.forEach(reservation -> {
            if(reservation.getTableReserving().getRestaurant().getOwner().getOwnerId()==ownerId){
                ReservationModel reservationModel = new ReservationModel();
                reservationModel.setReservationId(reservation.getReservationId());
                reservationModel.setCustomerReserving(reservation.getCustomerReserving());
                reservationModel.setTableReserving(reservation.getTableReserving());
                ownerReservations.add(reservationModel);
            }
        });
        return ownerReservations;
    }


}
