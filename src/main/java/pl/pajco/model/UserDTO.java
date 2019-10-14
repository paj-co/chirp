package pl.pajco.model;

import lombok.Data;
import pl.pajco.validation.ValidationGroupChangeUserInfo;
import pl.pajco.validation.ValidationGroupChangeUserPassword;
import pl.pajco.validation.ValidationGroupRegisterNewUser;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data class UserDTO {

    private Long id;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    private String firstName;
    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    private String lastName;
    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserInfo.class})
    private String nick;

    @NotEmpty(groups = {ValidationGroupRegisterNewUser.class, ValidationGroupChangeUserPassword.class})
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?])[a-zA-Z0-9!@#$%^&*?]{8,20}$")
    private String password;

    private String matchingPassword;

    @NotEmpty
    private String email;


}
