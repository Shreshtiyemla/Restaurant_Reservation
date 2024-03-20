package com.example.Restaurant.SpringSecurity.Validation;

import com.example.Restaurant.SpringSecurity.Model.RestaurantModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class RestaurantValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RestaurantModel restaurant = (RestaurantModel) target;

        // Validate restaurantId
        if (restaurant.getRestaurantId() <= 0) {
            errors.rejectValue("restaurantId", "restaurantId.invalid", "Invalid restaurant ID.");
        }

        // Validate restaurantName
        if (restaurant.getRestaurantName() == null || restaurant.getRestaurantName().isEmpty()) {
            errors.rejectValue("restaurantName", "restaurantName.empty", "Restaurant name is required.");
        }

        // Validate category
        if (restaurant.getCategory() == null || restaurant.getCategory().isEmpty()) {
            errors.rejectValue("category", "category.empty", "Category is required.");
        }

        // Validate address
        if (restaurant.getAddress() == null || restaurant.getAddress().isEmpty()) {
            errors.rejectValue("address", "address.empty", "Address is required.");
        }

        // Validate phoneNo
        if (restaurant.getPhoneNo() <= 0) {
            errors.rejectValue("phoneNo", "phoneNo.invalid", "Invalid phone number.");
        } else if (String.valueOf(restaurant.getPhoneNo()).length() != 10) {
            errors.rejectValue("phoneNo", "phoneNo.invalidLength", "Phone number must contain 10 digits.");
        }

        // Validate openingHours
        if (restaurant.getOpeningHours() == null) {
            errors.rejectValue("openingHours", "openingHours.invalid", "Opening hours are required.");
        }

        // Validate closingHours
        if (restaurant.getClosingHours() == null) {
            errors.rejectValue("closingHours", "closingHours.invalid", "Closing hours are required.");
        }
    }
}
