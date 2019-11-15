package pl.pajco.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.pajco.entity.Comment;
import pl.pajco.model.CurrentUser;
import pl.pajco.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/rest/comment")
public class CommentRestController {

    private CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/count/{chirpId}")
    public long getCountOfComments(@PathVariable long chirpId) {
        return commentService.countCommentsByChirpId(chirpId);
    }

    @GetMapping("/{chirpId}")
    public List<Comment> getAllCommentForChirp(@PathVariable long chirpId) {
        return commentService.getAllCommentForChirp(chirpId);
    }

    @PostMapping("/{chirpId}")
    public Comment newComment(@PathVariable long chirpId, @RequestBody Comment comment, @AuthenticationPrincipal CurrentUser currentUser) {
        return commentService.addComment(chirpId, comment, currentUser);
    }
}
