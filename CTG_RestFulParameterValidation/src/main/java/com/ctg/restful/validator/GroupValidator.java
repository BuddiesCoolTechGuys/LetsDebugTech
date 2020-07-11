package com.ctg.restful.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ctg.restful.Group;

/**
 * Customer Validator
 *
 */
public class GroupValidator implements ConstraintValidator<Group, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean validate = false;
		if (value.equals("Mathematics") || value.equals("Computer Science") || value.equals("Commerce")) {
			validate = true;
		}
		return validate;
	}
}
