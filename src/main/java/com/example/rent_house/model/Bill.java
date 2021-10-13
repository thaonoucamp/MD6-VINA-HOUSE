package com.example.rent_house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "id_users")
    @ManyToOne
    private Users users;
    private LocalDate startDay;
    private LocalDate endDay;
    @JoinColumn(name = "id_apartment")
    @OneToOne
    private Apartment apartment;
    private double total ;

}
