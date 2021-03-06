package com.example.rent_house.repository;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Bill;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface IRepositoryApartment extends CrudRepository<Apartment, Long> {
}
