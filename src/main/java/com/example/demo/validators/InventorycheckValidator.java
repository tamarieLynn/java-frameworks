package com.example.demo.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventorycheckValidator implements ConstraintValidator<Inventorycheck, Integer> {

    @Autowired
    private ApplicationContext context;

    public static ApplicationContext myContext;
    @Override
    public void initialize(Inventorycheck constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext){
        if(context==null)return true;
        if(context!=null)myContext=context;
        if (integer>5) return false;
        else return true;
    }
}
