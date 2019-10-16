package pl.pajco.entity;


import lombok.Data;

import javax.persistence.*;
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

    @Column(length = 60)
    private String password;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    private int enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}
