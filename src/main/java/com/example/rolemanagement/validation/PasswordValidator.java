package com.example.rolemanagement.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
   public void initialize(PasswordConstraint constraint) {
   }

   public boolean isValid(String password, ConstraintValidatorContext context) {

         if(password == null) return false;

         char[] charArray = password.toCharArray();
         boolean containsDigit = false;
         boolean containsUpperCase = false;

         for (char c : charArray) {
            if (Character.isDigit(c)) containsDigit = true;
            if (Character.isUpperCase(c)) containsUpperCase = true;
         }

         return containsDigit && containsUpperCase;
   }
}
