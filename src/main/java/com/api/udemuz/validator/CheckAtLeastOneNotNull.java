package com.api.udemuz.validator;

import org.apache.commons.beanutils.PropertyUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 04:39
 *
 * This is custom validator
 * To validate at least one of email or username
 * To be not null in AuthenticationDTO object
 * To authenticate
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckAtLeastOneNotNull.CheckAtLeastNotNullValidator.class)
@Documented
public @interface CheckAtLeastOneNotNull {
    String message() default "{com.api.element.validator.CheckAtLeastOneNotNull}";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fieldNames();

    public static class CheckAtLeastNotNullValidator implements ConstraintValidator<CheckAtLeastOneNotNull, Object> {
        private String[] fieldNames;

        @Override
        public void initialize(CheckAtLeastOneNotNull constraintAnnotation) {
            this.fieldNames = fieldNames;
        }

        @Override
        public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
            if (o == null) {
                return true;
            }
            try {
                for (String fieldName : fieldNames) {
                    Object property = PropertyUtils.getProperty(o, fieldName);
                    if (property != null) {
                        return true;
                    }
                }
            } catch (Exception e) {
                return false;
            }
            return false;
        }
    }
}
