package pl.pajco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pajco.entity.Chirp;
import pl.pajco.entity.User;

import java.util.List;

@Repository
public interface ChirpRepository extends JpaRepository<Chirp, Long> {

    List<Chirp> findChirpsByUserOrderByCreatedDesc(User user);
    List<Chirp> findChirpsByUserIdOrderByCreatedDesc(long id);

    List<Chirp> findChirpsByOrderByCreatedDesc();

    @Query(value = "SELECT * FROM chirp JOIN user ON chirp.user_id = user.id WHERE user.nick = ?1 ORDER BY chirp.created DESC", nativeQuery = true)
    List<Chirp> findChirpsByUserNick(String nick);

}
