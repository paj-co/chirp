package pl.pajco.validation;


import pl.pajco.model.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = (UserDTO) o;
        return userDTO.getPassword().equals(userDTO.getMatchingPassword());
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }
}
