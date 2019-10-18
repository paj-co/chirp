package pl.pajco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pajco.entity.Chirp;
import pl.pajco.repository.ChirpRepository;

import java.util.List;

@Service
public class ChirpService {

    private ChirpRepository chirpRepository;

    @Autowired
    private ChirpService(ChirpRepository chirpRepository) {
        this.chirpRepository = chirpRepository;
    }

    public List<Chirp> findAllChirps() {
        return chirpRepository.findChirpsByOrderByCreatedDesc();
    }

    public List<Chirp> findAllChirpsById(long userId) {
        return chirpRepository.findChirpsByUserIdOrderByCreatedDesc(userId);
    }

}
