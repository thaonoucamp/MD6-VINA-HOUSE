package com.example.rent_house.repository;

import com.example.rent_house.models.ApartmentDayInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryApartmentDayInOrder extends JpaRepository<ApartmentDayInOrder, Long> {
    @Query(value = "select * from apartment_day_in_order where apartment_id =?1 ",nativeQuery = true)
    Iterable<ApartmentDayInOrder> findAllByApartmentId(long apartmentId);
}

