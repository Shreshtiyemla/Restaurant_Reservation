package com.example.Restaurant.SpringSecurity.ServiceImpl;

public interface RewardPointsServiceImpl {
    public int getRewardPointsOfCustomer(int tableId, int customerId);
    public Double calaculateDiscountPrice(int rewardPoints, double tablePrice);
    public int paymentWithRewardPoints(int customerId, double billAmount, double tablePrice,int billId, String applyRewardPoints,int slotId);
}
