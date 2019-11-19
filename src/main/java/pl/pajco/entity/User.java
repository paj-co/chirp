package pl.pajco.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50, unique = true, nullable = false)
    private String nick;

    @JsonIgnore
    @Column(length = 60)
    private String password;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    private int enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Chirp> chirps;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", cascade = CascadeType.REMOVE)
    private List<Message> messagesSent;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE)
    private List<Message> messagesReceived;

}
