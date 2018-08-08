package envepro.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

@Component
public class FormValidator<T> {

@Autowired
Validator validator;


    public void validate(T o) {

        Set<ConstraintViolation<T>> violations = validator.validate(o);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<>(violations));
        }

    }

}
