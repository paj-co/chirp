package pl.pajco.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.pajco.service.RegistrationService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private RegistrationService registrationService;

    @Autowired
    private UniqueEmailValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !registrationService.checkIfEmailInDB(email);
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }
}
