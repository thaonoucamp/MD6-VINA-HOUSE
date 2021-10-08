package com.example.rent_house.repository;


import com.example.rent_house.models.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryApartment extends CrudRepository<Apartment, Long> {
}
