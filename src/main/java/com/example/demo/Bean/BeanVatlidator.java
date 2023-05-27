package com.example.demo.Bean;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.example.demo.model.User;

public class BeanVatlidator {
	public Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}

	public ArrayList<String> userSignupValidate(User user) {
		ArrayList<String> arrayList = new ArrayList<>();
		Set<ConstraintViolation<User>> constraintViolations = getValidator().validate(user);
		for (ConstraintViolation<User> constraintViolation : constraintViolations) {
			if (constraintViolation.getPropertyPath().toString().equals("firstName")) {
				arrayList.add(constraintViolation.getMessage());
			}
			if (constraintViolation.getPropertyPath().toString().equals("email")) {
				arrayList.add(constraintViolation.getMessage());
			}

		}
		return arrayList;
	}
}
