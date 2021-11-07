package com.pricing.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
@Constraint(validatedBy = CheckStatusNameValidator.class)
public @interface CheckStatusNameValidation {
	
	String message() default "L'état n'est pas valide. Les états valides sont: Neuf, Comme neuf, Très bon état, Bon état et Etat moyen.";
	//represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
