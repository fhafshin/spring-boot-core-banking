package ir.setad.banking.service.customValidator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
public @interface CustomValidation {

    String message() default "invalid national code!!!!!!!!!!!!!!!!!!!!!!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
