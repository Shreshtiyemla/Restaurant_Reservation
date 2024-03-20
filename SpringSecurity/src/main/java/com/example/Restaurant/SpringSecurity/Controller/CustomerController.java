package com.example.Restaurant.SpringSecurity.Controller;

import com.example.Restaurant.SpringSecurity.Entity.Customer;
import com.example.Restaurant.SpringSecurity.Entity.Reservation;
import com.example.Restaurant.SpringSecurity.Model.*;
import com.example.Restaurant.SpringSecurity.Service.*;
import com.example.Restaurant.SpringSecurity.ServiceImpl.*;
import com.example.Restaurant.SpringSecurity.Validation.CustomerValidation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    private int rId;

    private int customerId;

    private int tableId;


    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Autowired
    AvailableTablesServiceImpl tablesService;

    @Autowired
    SlotServiceImpl slotService;

    @Autowired
    BillServiceImpl billService;
    @Autowired
    RewardPointsServiceImpl rewardService;

    @Autowired
    CustomerValidation customerValidation;

    @RequestMapping("/customerPage")
    public String customer(){
        return "customerPage";
    }
    @RequestMapping("/registerCustomer")
    public String customerRegister(Model model){
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "customerRegister";
    }
    @RequestMapping("/customerRegistering")
    public String customerRegistering(@Valid @ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result, Model model) {
        // Perform validation
        customerValidation.validate(customerModel, result);
        // Check if there are validation errors
        if (result.hasErrors()) {
            // If there are errors, return to the registration form
            return "customerRegister";
        } else {
            // If no errors, proceed with registration
            Customer customer = customerService.customerRegister(customerModel);
            model.addAttribute("customerModel", customer);
            return "customerPage";
        }
    }
    @RequestMapping("/loginCustomer")
    public String customerLogin(Model model){
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "customerLogin";
    }
    @RequestMapping("/customerLogging")
    public String customerLogging(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  Model model) {
        CustomerModel customerModel = customerService.loginCredentials(username, password);
        if (customerModel != null ) {
            model.addAttribute("customerId", customerModel.getCustomerId());
            customerId = customerModel.getCustomerId();
            return "customerOperations";
        } else {
            return "redirect:/customerLogin";
        }
    }
    @RequestMapping("/viewAllRestaurants")
    public String viewRestaurants(RestaurantModel restaurantModel, Model model){
        List<RestaurantModel> restaurantModelList = restaurantService.getAllRestaurants(restaurantModel);
        model.addAttribute("restaurantModelList",restaurantModelList);
        model.addAttribute("customerId",customerId);
        return "viewAllRestaurants";
    }
    @RequestMapping("/restaurantsByCategory")
    public String viewRestaurantsByCategory(@RequestParam("category") String category, Model model) {
        List<RestaurantModel> restaurantModelList = restaurantService.getRestaurantsByCategory(category);
        model.addAttribute("restaurantModelList", restaurantModelList);
        model.addAttribute("customerId",customerId);
        return "viewRestaurantsByCategory";
    }

    @RequestMapping("/tablesOfRestaurant")
    public String getRestaurantTables(@RequestParam("restaurantId") int restaurantId, Model model){
        ArrayList<AvailableTablesModel> availableTablesModelList = tablesService.getRestaurantTables(restaurantId);
        model.addAttribute("availableTablesModelList",availableTablesModelList);
        model.addAttribute("restaurantId",restaurantId);
        System.out.println(rId);
        System.out.println(availableTablesModelList);
        return "tablesOfRestaurant";
    }
    @RequestMapping("/viewSlotsByCustomer")
    public String viewSlots(@RequestParam("restaurantId") int id,@RequestParam("table") int tid, Model model) {
        tableId=tid;
        rId=id;
        List<SlotModel> slotModelsList = slotService.getSlots(tid);
        model.addAttribute("slotModel", slotModelsList);
        model.addAttribute("rId", id);
        System.out.println(slotModelsList);
        return "viewSlotsByCustomer";
    }
    @RequestMapping("/reserveTable")
    public String reserveTable(@RequestParam("slot") int sid, ModelMap map) {
        int reserveId = reservationService.reserveTableOfRestuarent(customerId, tableId, sid);
        map.addAttribute("customerId",customerId);
        map.addAttribute("reservationId",reserveId);
        return "result";
    }
    @RequestMapping("/bill")
    public String generateBillsForReservation(@RequestParam("customerId") int customerId,
                                              @RequestParam("reservationId") int reservationId,
                                              Model model) {
        System.out.println(reservationId);
        BillModel billModel = (BillModel) billService.generateABillForCustomer(customerId,reservationId);
        System.out.println(billModel);
        model.addAttribute("bills", billModel);
        model.addAttribute("reservationId", reservationId);
        model.addAttribute("customerId",customerId);
        model.addAttribute("tableId",tableId);
        System.out.println(billModel.getReservation().getSlot().getSlotId());
        return "viewBill";
    }
//    @RequestMapping("/viewCustomerBill")
//    public String viewBill(Model model){
//        List<BillModel> billModelList = billService.getBills(customerId);
//        model.addAttribute("billModelList",billModelList);
//        model.addAttribute("customerId",customerId);
//        return "viewBill";
//    }
    @RequestMapping("/processPaymentAndRewardPoints")
    public String processPaymentAndRewardPoints(@RequestParam("customerId") int customerId,
                                                @RequestParam("tableId") int tableId,
                                                @RequestParam("slotId") int slotId,
                                                @RequestParam("billId") int billId,
                                                @RequestParam("reservationId") int reservationId,
                                                @RequestParam("tablePrice") double tablePrice,
                                                Model model) {
        int rewardPoints = rewardService.getRewardPointsOfCustomer(tableId, customerId);
        Double discountPrice=tablePrice;
        if (rewardPoints > 0) {
            discountPrice = rewardService.calaculateDiscountPrice(rewardPoints, tablePrice);
        }
        model.addAttribute("message", "Payment processed successfully and reward points generated.");
        model.addAttribute("customerId", customerId);
        model.addAttribute("tableId", tableId);
        model.addAttribute("slotId", slotId);
        model.addAttribute("tablePrice", tablePrice);
        model.addAttribute("billId", billId);
        model.addAttribute("discountPrice", discountPrice);
        model.addAttribute("reservationId", reservationId);
        model.addAttribute("rewardPoints", rewardPoints);
        return "payment";
    }
    @RequestMapping("/pay")
    public String generateRewardPoints(@RequestParam("billId") int billId,
                                       @RequestParam("customerId") int customerId,
                                       @RequestParam("reservationId") int reservationId,
                                       @RequestParam("tableId") int tableId,
                                       @RequestParam("slotId") int slotId,
                                       @RequestParam("discountPrice") double discountPrice,
                                       @RequestParam("tablePrice") double billAmount,
                                       @RequestParam("tablePrice") double tablePrice,

                                       @RequestParam("applyRewardPoints") String applyRewardPoints, Model model){
      //  int reward=rewardService.addRewardPointsToBill(customerId,billId,billAmount,rewardPoints);
        System.out.println("rewardPoints: "+applyRewardPoints);
        if(applyRewardPoints.equals("yes")){
            billAmount=discountPrice;
        }
        System.out.println(discountPrice+" "+billAmount);
        model.addAttribute("billId",billId);
        model.addAttribute("customerId",customerId);
        model.addAttribute("reservationId",reservationId);
        model.addAttribute("billAmount",billAmount);
        model.addAttribute("tablePrice",tablePrice);
        model.addAttribute("slotId", slotId);
        model.addAttribute("applyRewardPoints",applyRewardPoints);
        return "viewPayment";
    }
    @RequestMapping("/useRewardPoints")
    public String useRewardPoints(@RequestParam("customerId") int customerId,
                                  @RequestParam("billId") int billId,
                                  @RequestParam("slotId") int slotId,
                                  @RequestParam("billAmount") double billAmount,
                                  @RequestParam("tablePrice") double tablePrice,
                                  @RequestParam("applyRewardPoints") String applyRewardPoints,
                                  Model model) {
        System.out.println("applyRewardPoints"+applyRewardPoints);
        int rewardPoints = rewardService.paymentWithRewardPoints(customerId, billAmount,tablePrice,billId,applyRewardPoints,slotId);
        System.out.println("Updated rewardPoints "+ rewardPoints);
        model.addAttribute("billAmount",billAmount);
        model.addAttribute("customerId",customerId);
        model.addAttribute("rewardPoints", rewardPoints);
        return "paymentSuccess";
    }
    @RequestMapping("/viewYourBookings")
    public String viewBookedSlots(@RequestParam("customerId") int customerId, Model model) {
        List<Reservation> bookedSlots = reservationService.getBookedSlotsForCustomer(customerId);
        model.addAttribute("bookedSlots", bookedSlots);
        model.addAttribute("customerId",customerId);
        return "viewBookings";
    }
    @RequestMapping("/cancelReservation")
    public String cancelReservation(@RequestParam("reservationId") int reservationId, @RequestParam("slotId") int slotId, Model model) {
        String cancellationMessage = reservationService.cancelReservation(reservationId, slotId);
        model.addAttribute("cancellationMessage", cancellationMessage);
        return "cancelResult";
    }

}
