package com.example.Restaurant.SpringSecurity.Validation;

import com.example.Restaurant.SpringSecurity.Model.OwnerModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class OwnerValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OwnerModel owner = (OwnerModel) target;

        // Validate ownerId
        if (owner.getOwnerId() == 0) {
            errors.rejectValue("ownerId", "ownerId.empty", "Owner ID is required.");
        }

        // Validate ownerName
        if (owner.getOwnerName() == null || owner.getOwnerName().isEmpty()) {
            errors.rejectValue("ownerName", "ownerName.empty", "Owner name is required.");
        }

        // Validate ownerUsername
        if (owner.getUsername() == null || owner.getUsername().isEmpty()) {
            errors.rejectValue("username", "username.empty", "Owner username is required.");
        }

        // Validate ownerPassword
        if (owner.getPassword() == null || owner.getPassword().isEmpty()) {
            errors.rejectValue("password", "password.empty", "Owner password is required.");
        }

        // Validate email
        if (owner.getEmail() == null || owner.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty", "Email is required.");
        } else if (!owner.getEmail().endsWith("@gmail.com")) {
            errors.rejectValue("email", "email.invalidFormat", "Invalid email format.");
        }

        // Validate mobileNo
        if (owner.getMobileNo() == null) {
            errors.rejectValue("mobileNo", "mobileNo.empty", "Mobile number is required.");
        } else if (owner.getMobileNo().toString().length() != 10) {
            errors.rejectValue("mobileNo", "mobileNo.invalidLength", "Mobile number must contain 10 digits.");
        }
    }
}
