package com.example.rent_house.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private String userFullName;
    private String phoneNumber;
    private String status;
    private double totalPaid;
    private double rating;
    private String comment;
    private boolean checkIn;

    @ManyToOne
    private Apartment apartment;

    @ManyToOne
    private User user;
}
