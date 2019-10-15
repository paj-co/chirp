package pl.pajco.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50, unique = true)
    private String nick;

    @Column(length = 20)
    private String password;

    @Column(length = 50, unique = true)
    private String email;


}
