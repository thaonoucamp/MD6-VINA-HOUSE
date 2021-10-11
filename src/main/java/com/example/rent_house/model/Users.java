package com.example.rent_house.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 50)
    private String username;

    @JsonIgnore
    @NotBlank
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 50)
    private String email;

    @NotBlank
    @Size(min = 3, max = 50)
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

    public Users(String name, String username, String email, String password) {
        this.fullName=name;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
