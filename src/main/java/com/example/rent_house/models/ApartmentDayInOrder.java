package com.example.rent_house.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class ApartmentDayInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dayInOrder;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment dayInOrderApartment;

    public ApartmentDayInOrder(Date dayInOrder, Apartment apartment) {
        this.dayInOrder = dayInOrder;
        this.dayInOrderApartment = apartment;
    }

    public ApartmentDayInOrder() {
    }
}
