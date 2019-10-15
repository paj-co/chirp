package pl.pajco.model;

import lombok.Data;
import pl.pajco.validation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@PasswordMatches(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
public @Data class UserDTO {

    private Long id;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    private String firstName;
    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    private String lastName;
    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    //TODO unique nic validation
    private String nick;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?])[a-zA-Z0-9!@#$%^&*?]{4,20}$",
            groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
    private String password;

    private String matchingPassword;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @Email(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @UniqueEmail(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class},
            message = "This email is already attached to user account")
    private String email;


}
