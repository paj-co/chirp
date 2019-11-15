package pl.pajco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pajco.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByChirp_IdOrderByCreatedDesc(long id);

    Long countCommentsByChirp_Id(long id);

}
