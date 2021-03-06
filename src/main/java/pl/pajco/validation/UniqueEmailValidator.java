package pl.pajco.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.pajco.service.RegisterService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private RegisterService registerService;

    @Autowired
    private UniqueEmailValidator(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !registerService.checkIfEmailInDB(email);
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }
}
