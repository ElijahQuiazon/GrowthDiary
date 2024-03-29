package com.growthdiary.sessionlog.tracker.validators;

import com.growthdiary.sessionlog.tracker.models.Details;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * This class is a Spring Validator implementation used to validate instances of the Details object
 * Checks validity of Details object attributes
 *
 * @see Details
 */
@Component
public class DetailsValidator implements Validator {

    @Override
    public boolean supports(@NotNull Class clazz) {
        return Details.class.equals(clazz);
    }

    /**
     * Validates the given Details object
     * Checks for null-values
     *
     * @param target Details object to be validated
     * @param errors Stores any validation errors encountered
     */
    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {

        Details details = (Details) target;

        if (details.getTopic() == null || details.getTopic().isEmpty()) {
            errors.rejectValue("topic", "topic.null", "Topic must not be empty");
        }

        if (details.getDescription() == null || details.getDescription().isEmpty()) {
            errors.rejectValue("description", "description.null", "Description must not be empty");
        }
    }
}
