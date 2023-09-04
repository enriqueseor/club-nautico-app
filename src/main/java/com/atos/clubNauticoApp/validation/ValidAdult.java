package com.atos.clubNauticoApp.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AdultValidator.class)
@Target(value = ElementType.FIELD)//Type se aplica a la clase y field al campo
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidAdult {

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}