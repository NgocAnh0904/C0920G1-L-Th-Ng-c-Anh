package custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
@Documented
public @interface TestCustom {
    String message() default "abcxyzzzzzzzzzzzzzzz";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
