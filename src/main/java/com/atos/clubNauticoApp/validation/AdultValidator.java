package com.atos.clubNauticoApp.validation;

import java.util.Calendar;
import java.util.Date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public final class AdultValidator implements ConstraintValidator<ValidAdult, Date> {

	@Override
	public boolean isValid(Date birthdate, ConstraintValidatorContext context) {
		if (birthdate ==  null) {
			return true;
		}else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -18);
            return !birthdate.after(cal.getTime());
		}
    }
}
