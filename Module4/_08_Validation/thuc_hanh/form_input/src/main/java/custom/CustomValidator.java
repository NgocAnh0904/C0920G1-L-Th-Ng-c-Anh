package custom;

import com.codegym.demo.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;

public class CustomValidator implements ConstraintValidator<TestCustom, User> {


    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return false;
    }
}
