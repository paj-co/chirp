package pl.pajco.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public @Data class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 280)
    private String commentText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "chirp_id")
    private Chirp chirp;

    private LocalDateTime created;

    @PrePersist
    private void prePersist() {
        created = LocalDateTime.now();
    }

}
