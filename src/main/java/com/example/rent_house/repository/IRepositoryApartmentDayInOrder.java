package com.example.rent_house.repository;

import com.example.rent_house.models.ApartmentDayInOrder;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryApartmentDayInOrder extends CrudRepository<ApartmentDayInOrder, Long> {
}
