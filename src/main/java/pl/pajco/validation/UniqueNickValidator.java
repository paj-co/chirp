package pl.pajco.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.pajco.service.RegisterService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNickValidator implements ConstraintValidator<UniqueNick, String> {

    private RegisterService registerService;

    @Autowired
    public UniqueNickValidator(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    public boolean isValid(String nick, ConstraintValidatorContext constraintValidatorContext) {
        return !registerService.checkIfNickInDB(nick);
    }

    @Override
    public void initialize(UniqueNick constraintAnnotation) {

    }
}
