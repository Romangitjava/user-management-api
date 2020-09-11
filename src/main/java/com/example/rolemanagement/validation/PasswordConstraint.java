package com.example.rolemanagement.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {
    String message() default "Password invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}