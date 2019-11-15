package pl.pajco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pajco.entity.Chirp;
import pl.pajco.entity.Comment;
import pl.pajco.model.CurrentUser;
import pl.pajco.repository.ChirpRepository;
import pl.pajco.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private ChirpRepository chirpRepository;

    @Autowired
    private CommentService(CommentRepository commentRepository, ChirpRepository chirpRepository) {
        this.commentRepository = commentRepository;
        this.chirpRepository = chirpRepository;
    }

    public long countCommentsByChirpId(long chirpId) {
        return commentRepository.countCommentsByChirp_Id(chirpId);
    }

    public List<Comment> getAllCommentForChirp(long chirpId) {
        return commentRepository.findCommentsByChirp_IdOrderByCreatedDesc(chirpId);
    }

    public Comment addComment(long chirpId, Comment comment, CurrentUser currentUser) {
        Chirp chirp = chirpRepository.findById(chirpId).orElse(null);
        if (chirp != null) {
            comment.setChirp(chirp);
            comment.setUser(currentUser.getUser());
            return commentRepository.save(comment);
        }
        return null;
    }

}
