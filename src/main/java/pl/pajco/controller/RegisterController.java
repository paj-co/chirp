package pl.pajco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pajco.model.UserDTO;
import pl.pajco.service.RegisterService;
import pl.pajco.validation.ValidationGroupRegisterNewUser;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private RegisterService registerService;

    @Autowired
    private RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("")
    public String registerUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("")
    public String registerUser(@ModelAttribute @Validated(ValidationGroupRegisterNewUser.class) UserDTO userDTO,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "register";
        }
        registerService.registerUser(userDTO);
        return "redirect:/login";
    }

}
