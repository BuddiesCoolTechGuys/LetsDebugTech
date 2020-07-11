package com.ctg.restful;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ctg.restful.validator.GroupValidator;

/**
 * Customer Annotation Declaration
 * @author CTG
 *
 */
//@Documented
@Constraint(validatedBy = GroupValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Group {

	String message() default "{student.group.validate}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
