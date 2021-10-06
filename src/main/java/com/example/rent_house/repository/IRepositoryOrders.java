package com.example.rent_house.repository;

import com.example.rent_house.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryOrders extends CrudRepository<Orders, Long> {
}
