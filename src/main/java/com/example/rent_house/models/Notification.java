package com.example.rent_house.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private Users users;

    public Notification() {
    }

    public Notification(String content, Users users) {
        this.content = content;
        this.users = users;
    }

    public Notification(Long id, String content, Users users) {
        this.id = id;
        this.content = content;
        this.users = users;
    }
}
