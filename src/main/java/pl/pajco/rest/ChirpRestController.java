package pl.pajco.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pajco.entity.Chirp;
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
    public List<Chirp> getAllChirps() {
        return chirpService.findAllChirps();
    }


}
