package pl.pajco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chirp")
public @Data class Chirp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 280)
    private String text;

    private LocalDateTime created;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "chirp")
    private List<Comment> comments;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }


}
