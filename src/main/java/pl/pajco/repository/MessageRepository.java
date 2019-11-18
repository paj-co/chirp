package pl.pajco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pajco.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
