package com.example.rent_house.repository;

import com.example.rent_house.model.TypeApartment;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryTypeApartment extends CrudRepository<TypeApartment, Long> {
}
