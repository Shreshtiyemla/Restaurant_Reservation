package com.example.Restaurant.SpringSecurity.Controller;
import com.example.Restaurant.SpringSecurity.Entity.Owner;
import com.example.Restaurant.SpringSecurity.Model.*;
import com.example.Restaurant.SpringSecurity.Service.AvailableTablesService;
import com.example.Restaurant.SpringSecurity.Service.OwnerService;
import com.example.Restaurant.SpringSecurity.Service.RestaurantService;
import com.example.Restaurant.SpringSecurity.Service.SlotService;
import com.example.Restaurant.SpringSecurity.ServiceImpl.AvailableTablesServiceImpl;
import com.example.Restaurant.SpringSecurity.ServiceImpl.OwnerServiceImpl;
import com.example.Restaurant.SpringSecurity.ServiceImpl.RestaurantServiceImpl;
import com.example.Restaurant.SpringSecurity.ServiceImpl.SlotServiceImpl;
import com.example.Restaurant.SpringSecurity.Validation.OwnerValidation;
import com.example.Restaurant.SpringSecurity.Validation.RestaurantValidation;
import com.example.Restaurant.SpringSecurity.Validation.TableValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OwnerController {
    private int ownerId;
    private int rId;
    private int sId;
    @Autowired
    OwnerServiceImpl ownerService;

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Autowired
    AvailableTablesServiceImpl tablesService;

    @Autowired
    SlotServiceImpl slotService;

    @Autowired
    OwnerValidation ownerValidator;

    @Autowired
    RestaurantValidation restaurantValidator;

    @Autowired
    TableValidation availableTablesValidator;

    @RequestMapping("/")
    public String start() {
        return "start";
    }

    @RequestMapping("/ownerPage")
    public String register() {
        return "ownerPage";
    }

    @RequestMapping("/register")
    public String showOwnerRegistrationForm(Model model) {
        model.addAttribute("ownerModel", new OwnerModel());
        return "ownerRegister";
    }

    @RequestMapping("/ownerRegister")
    public String registeringOwner(@Valid @ModelAttribute("ownerModel") OwnerModel ownerModel, BindingResult result, Model model) {
        ownerValidator.validate(ownerModel, result);
        if (result.hasErrors()) {
            return "ownerRegister";
        }
        System.out.println(ownerModel);
        Owner owner = ownerService.registerOwner(ownerModel);
        model.addAttribute("ownerModel", owner);
        return "ownerPage";
    }

    @RequestMapping("/loginOwner")
    public String login() {
        return "ownerLogin";
    }
    @RequestMapping("/ownerLogin")
    public String loginOwner(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        OwnerModel ownerModel = ownerService.loginOwner(username, password);
        System.out.println(ownerModel);
        if(ownerModel!=null){
            model.addAttribute("ownerId", ownerModel.getOwnerId());
            ownerId = ownerModel.getOwnerId();
            return "ownerOperations";
        } else {
            return "ownerLoginFailed";
        }
    }
    @RequestMapping("/add")
    public String showRestaurantForm(Model model) {
        model.addAttribute("restaurantModel", new RestaurantModel());
        return "addRestaurants";
    }

    @RequestMapping("/addRestaurant")
    public String addRestaurants(@ModelAttribute("restaurantModel") RestaurantModel restaurantModel, BindingResult result, Model model) {
        restaurantValidator.validate(restaurantModel, result);
        if (result.hasErrors()) {
            return "addRestaurants";
        }

        RestaurantModel restaurantModel1 = restaurantService.saveRestaurant(ownerId, restaurantModel);
        model.addAttribute("restaurantModel", restaurantModel1);
        model.addAttribute("ownerId", ownerId);
        return "ownerOperations";
    }
    @RequestMapping("/viewOwner")
    public String getOwnerRestaurants(Model model) {
        List<RestaurantModel> restaurantModelsList = restaurantService.getOwnerRestaurants(ownerId);
        model.addAttribute("restaurantModelsList", restaurantModelsList);
        model.addAttribute("ownerId", ownerId);
        return "viewRestaurants";
    }

    @RequestMapping("/addTable")
    public String addTable(@RequestParam("restaurantId") int restaurantId, Model model) {
        System.out.println(restaurantId);
        AvailableTablesModel availableTablesModel = new AvailableTablesModel();
        model.addAttribute("availableTablesModel",availableTablesModel);
        model.addAttribute("restaurantId", restaurantId);
        rId = restaurantId;
        return "addTables";
    }
    @RequestMapping("/addingTables")
    public String addingTables(@Valid AvailableTablesModel availableTablesModel, BindingResult result, Model model) {
        // Validate the AvailableTablesModel
        availableTablesValidator.validate(availableTablesModel, result);
        if (result.hasErrors()) {
            // If there are validation errors, return to the form with error messages
            return "addTables"; // Change "yourErrorPage" to the appropriate error page
        }
        System.out.println(rId);
        AvailableTablesModel availableTablesModel1 = tablesService.addTable(rId, availableTablesModel);
        model.addAttribute("availableTablesModel", availableTablesModel1);
        model.addAttribute("restaurantId", rId);
        return "viewRestaurants";
    }
    @RequestMapping("/viewRestaurantTables")
    public String getRestaurantTables(@RequestParam("restaurantId") int restaurantId, Model model) {
        List<AvailableTablesModel> availableTablesModelList = tablesService.getRestaurantTables(restaurantId);
        model.addAttribute("availableTablesModelList", availableTablesModelList); // Ensure it's a list
        model.addAttribute("restaurantId", restaurantId);
        return "viewTables";
    }

    @RequestMapping("/slot")
    public String slot() {
        return "generateSlots";
    }
    @RequestMapping("/generateSlots")
    public String generateSlotsForTable(@RequestParam("restaurantId") int restaurantId,
                                        @RequestParam("tableId") int tableId,
                                        Model model) {
        slotService.generateSlotsForTableInRestaurant(restaurantId, tableId);
        System.out.println(tableId);
        model.addAttribute("message", "Slots generated successfully for table " + tableId + " in restaurant " + restaurantId);
        model.addAttribute("restaurantId",rId);
        model.addAttribute("tableId",tableId);
        return "addSlotSuccess";
    }
    @RequestMapping("/viewSlots")
    public String viewSlots(@RequestParam("tableId") int tableId, Model model) {
        List<SlotModel> slotModelsList = slotService.getSlots(tableId);
        model.addAttribute("slotModel", slotModelsList);
        model.addAttribute("tableId", tableId);
        return "viewSlots";
    }
    @RequestMapping("/viewReservations")
    public String viewReservations(@RequestParam("ownerId") int ownerId,Model model){
        List<ReservationModel> reservationModelsList = ownerService.getAllReservations(ownerId);
        model.addAttribute("reservationModelsList",reservationModelsList);
        return "viewAllReservations";
    }

}
