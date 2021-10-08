package com.example.rent_house.service.orders;

import com.example.rent_house.models.Orders;
import com.example.rent_house.service.IGenericService;

import java.util.Optional;

public interface IOrdersService extends IGenericService<Orders> {
    Optional<Orders> findById(long id);

    void delete(long id);

    Iterable<Orders> findAllOrderOfUserHasApartment(long apartmentUserId);
    Iterable<Orders> findAllByUserId(Long users_id);
    Iterable<Orders> findAllByApartmentId(Long apartment_id);
    Iterable<Orders> findAllOrderOfApartmentWithPending(long apartmentId);

    Iterable<Orders> findAllByUsersId(Long id);
    Iterable<Orders> findAllByApartment(Long apartmentID);
}
