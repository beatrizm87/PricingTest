package com.pricing.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pricing.model.enums.ProductStatus;

public class CheckStatusNameValidator implements ConstraintValidator<CheckStatusNameValidation, String>
{
	@Override
    public boolean isValid(String statusName,  ConstraintValidatorContext cxt) {
    	boolean isValid;
    	try
    	{
    		isValid = ProductStatus.fromDescription(statusName) != null;
    	}
    	catch (IllegalArgumentException e)
    	{
    		isValid = false;
		}
    	return isValid;
    }
}
