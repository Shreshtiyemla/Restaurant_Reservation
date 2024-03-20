package com.example.Restaurant.SpringSecurity.Validation;

import com.example.Restaurant.SpringSecurity.Model.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class CustomerValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerModel customer = (CustomerModel) target;

        // Validate customerId
        if (customer.getCustomerId() == 0) {
            errors.rejectValue("customerId", "customerId.empty", "Customer ID is required.");
        }

        // Validate customerName
        if (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
            errors.rejectValue("customerName", "customerName.empty", "Customer name is required.");
        }

        // Validate customerUsername
        if (customer.getUsername() == null || customer.getUsername().isEmpty()) {
            errors.rejectValue("username", "Username.empty", "Customer username is required.");
        }

        // Validate customerPassword
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            errors.rejectValue("password", "Password.empty", "Customer password is required.");
        }

        // Validate customerEmail
        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().isEmpty()) {
            errors.rejectValue("customerEmail", "customerEmail.empty", "Email is required.");
        } else if (!customer.getCustomerEmail().endsWith("@gmail.com")) {
            errors.rejectValue("customerEmail", "customerEmail.invalidFormat", "Invalid email format.");
        }

        // Validate Address
        if (customer.getAddress() == null || customer.getAddress().isEmpty()) {
            errors.rejectValue("Address", "Address.empty", "Address is required.");
        }

        // Validate phoneNumber
        if (customer.getPhoneNumber() == 0) {
            errors.rejectValue("phoneNumber", "phoneNumber.empty", "Phone number is required.");
        } else if (String.valueOf(customer.getPhoneNumber()).length() != 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalidLength", "Phone number must contain 10 digits.");
        }
    }
}
