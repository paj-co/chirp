package pl.pajco.model;

import lombok.Data;
import pl.pajco.validation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@PasswordMatches(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
public @Data class UserDTO {

    private Long id;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @Size(max = 50)
    private String firstName;
    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @Size(max = 50)
    private String lastName;
    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @UniqueNick(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @Size(max = 50)
    private String nick;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?])[a-zA-Z0-9!@#$%^&*?]{4,20}$",
            groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
    @Size(min = 4, max = 20)
    private String password;
    private String matchingPassword;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @Email(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    @UniqueEmail(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class},
            message = "This email is already attached to user account")
    @Size(max = 50)
    private String email;


}
