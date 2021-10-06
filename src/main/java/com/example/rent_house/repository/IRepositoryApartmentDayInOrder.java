package com.example.rent_house.repository;

import com.example.rent_house.model.ApartmentDayInOrder;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryApartmentDayInOrder extends CrudRepository<ApartmentDayInOrder, Long> {
}
