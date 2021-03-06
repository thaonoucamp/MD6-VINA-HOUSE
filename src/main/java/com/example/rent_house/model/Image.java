package com.example.rent_house.model;

import com.example.rent_house.model.Apartment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private Users users;

    @JsonBackReference
//    chống lặp vô hạn dữ liệu

    @ManyToOne
    @JoinColumn(name = "id_apartment")
    private Apartment apartmentImage;
    private String nameUrl;
}
