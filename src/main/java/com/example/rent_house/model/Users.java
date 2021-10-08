package com.example.rent_house.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;
    private String fullName;
    private String avatar;
    private String city;

    @ManyToMany
    @JsonBackReference
    Set<Roles> roles = new HashSet<>();

    public Users() {
    }

    public Users(String username,
                 String encode) {
        this.username = username;
        this.password = encode;
    }


}
