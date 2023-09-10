package com.example.demo.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {InventorycheckValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inventorycheck {
    String message() default "You cannot add this amount";
    Class<?>[] groups() default{};
    Class<? extends Payload> [] payload() default {};
}
