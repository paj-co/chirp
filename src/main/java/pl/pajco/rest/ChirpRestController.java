package pl.pajco.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.pajco.entity.Chirp;
import pl.pajco.entity.User;
import pl.pajco.model.CurrentUser;
import pl.pajco.service.ChirpService;

import java.util.List;

@RestController
@RequestMapping("/rest/chirps")
public class ChirpRestController {

    private ChirpService chirpService;

    @Autowired
    public ChirpRestController(ChirpService chirpService) {
        this.chirpService = chirpService;
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Chirp> getAllChirps() {
        return chirpService.findAllChirps();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Chirp addChirp(@RequestBody Chirp chirp, @AuthenticationPrincipal CurrentUser currentUser) {
        return chirpService.addChirp(currentUser, chirp);
    }

    @GetMapping("/loggedUser")
    public User loggedUser(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser.getUser();
    }



}
