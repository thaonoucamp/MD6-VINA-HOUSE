package com.example.rent_house.service.orders;

import com.example.rent_house.model.Orders;
import com.example.rent_house.repository.IRepositoryOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersServiceImp implements IOrdersService {
    @Autowired
    IRepositoryOrders repositoryOrders;

    @Override
    public Iterable<Orders> getAll() {
        return repositoryOrders.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryOrders.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return repositoryOrders.save(orders);
    }

    @Override
    public void delete(Long id) {
        repositoryOrders.deleteById(id);
    }
}
