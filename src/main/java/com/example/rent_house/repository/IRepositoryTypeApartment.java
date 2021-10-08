package com.example.rent_house.repository;


import com.example.rent_house.models.TypeApartment;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryTypeApartment extends CrudRepository<TypeApartment, Long> {
}
