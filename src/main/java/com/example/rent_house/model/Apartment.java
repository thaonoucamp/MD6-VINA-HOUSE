package com.example.rent_house.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "apartmentImage", cascade = CascadeType.REMOVE)
    private List<Image> images;
    private String name;
    private String address;
    private String ward;
    private String district;
    private String city;
    private Long bathroom;
    private Long bedroom;
    private String description;
    private double price;
    private String status;
    private Long numberView;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    private TypeApartment typeApartment;

}
