package com.example.Restaurant.SpringSecurity.Validation;

import com.example.Restaurant.SpringSecurity.Model.AvailableTablesModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class TableValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AvailableTablesModel availableTables = (AvailableTablesModel) target;

        // Validate tableId
        if (availableTables.getTableId() <= 0) {
            errors.rejectValue("tableId", "tableId.invalid", "Invalid table ID.");
        }

        // Validate capacity
        if (availableTables.getCapacity() <= 0) {
            errors.rejectValue("capacity", "capacity.invalid", "Capacity must be greater than 0.");
        }

        // Validate price
        if (availableTables.getPrice() <= 0) {
            errors.rejectValue("price", "price.invalid", "Price must be greater than 0.");
        }

        // You may add additional validations as needed

    }
}
