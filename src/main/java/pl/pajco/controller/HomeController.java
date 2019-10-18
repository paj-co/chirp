package pl.pajco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pajco.service.ChirpService;

@Controller
public class HomeController {

    private ChirpService chirpService;

    @Autowired
    public HomeController(ChirpService chirpService) {
        this.chirpService = chirpService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("allChirps", chirpService.findAllChirps());
        return "user/home";
    }

}
