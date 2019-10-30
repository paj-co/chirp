package pl.pajco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "user/home";
    }

    @GetMapping(value = "/")
    public String redirectHome() {
        return "redirect:/home";
    }

    @GetMapping("/{userNick}")
    public String userProfile(@PathVariable String userNick) {
        return "user/userProfile";
    }

}
