package com.example.rent_house.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private String userFullName;
    private String userPhoneNums;
    private String orderStatus;
    private Double totalPaid;
    private Double rating;
    private String comment;
    private Boolean checkIn;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Apartment apartment;

    public Orders(Date startDate, Date endDate, String userFullName, String userPhoneNums, String orderStatus, Double totalPaid, Double rating, String comment, Boolean checkIn, Users users, Apartment apartment) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.userFullName = userFullName;
        this.userPhoneNums = userPhoneNums;
        this.orderStatus = orderStatus;
        this.totalPaid = totalPaid;
        this.rating = rating;
        this.comment = comment;
        this.checkIn = checkIn;
        this.users = users;
        this.apartment = apartment;
    }

    public Orders() {
    }

    public Orders(Long id, Date startDate, Date endDate, String userFullName, String userPhoneNums, String orderStatus, Double totalPaid, Double rating, String comment, Boolean checkIn, Users users, Apartment apartment) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userFullName = userFullName;
        this.userPhoneNums = userPhoneNums;
        this.orderStatus = orderStatus;
        this.totalPaid = totalPaid;
        this.rating = rating;
        this.comment = comment;
        this.checkIn = checkIn;
        this.users = users;
        this.apartment = apartment;
    }
}
