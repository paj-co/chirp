package pl.pajco.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public @Data class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String text;

    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private User receiver;

    @Column(columnDefinition = "tinyint default 0")
    private Integer seen;

    private LocalDateTime created;

    @PrePersist
    private void prePersistCreated() {
        created = LocalDateTime.now();
    }


}
