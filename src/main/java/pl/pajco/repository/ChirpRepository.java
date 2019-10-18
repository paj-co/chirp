package pl.pajco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pajco.entity.Chirp;
import pl.pajco.entity.User;

import java.util.List;

@Repository
public interface ChirpRepository extends JpaRepository<Chirp, Long> {

    List<Chirp> findChirpsByUserOrderByCreatedDesc(User user);
    List<Chirp> findChirpsByUserIdOrderByCreatedDesc(long id);

    List<Chirp> findChirpsByOrderByCreatedDesc();

}
