package com.example.rent_house.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "apartmentId")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;
}
