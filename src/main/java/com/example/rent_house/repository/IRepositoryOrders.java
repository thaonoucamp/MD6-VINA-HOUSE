package com.example.rent_house.repository;

import com.example.rent_house.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRepositoryOrders extends JpaRepository<Orders, Long> {
    @Query(value = "select * from orders where user_id =?1 ", nativeQuery = true)
    Iterable<Orders> findAllByUserId(Long user_id);

    @Query(value = "select * from orders where apartment_id =?1", nativeQuery = true)
    Iterable<Orders> findAllByApartmentId(Long apartment_id);


    @Query(value = "select * from orders join apartment on orders.apartment_id = apartment.id where apartment.user_id =?1", nativeQuery = true)
    Iterable<Orders> findAllOrderOfUserHasApartment(long apartmentUserId);

    @Query(value = "select * from orders where apartment_id =?1 and order_status like 'Pending' order by id desc", nativeQuery = true)
    Iterable<Orders> findAllOrderOfApartmentWithPending(long apartmentId);

    @Modifying
    @Query(value = "select * from Order where user_id = :id", nativeQuery = true)
    Iterable<Orders> getAllByUserId(@Param("id") Long id);

    @Query(value = "select * from Order o where o.apartment_id = :apartmentID", nativeQuery = true)
    Iterable<Orders> findAllByApartment(@Param("apartmentID") Long apartmentID);
}
