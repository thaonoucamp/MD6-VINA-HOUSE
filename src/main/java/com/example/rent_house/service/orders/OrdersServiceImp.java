package com.example.rent_house.service.orders;

import com.example.rent_house.models.Orders;
import com.example.rent_house.repository.IRepositoryOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersServiceImp implements IOrdersService {
    @Autowired
    private IRepositoryOrders ordersRepository;

    @Override
    public Iterable<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Orders> findById(long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Iterable<Orders> findAllOrderOfUserHasApartment(long apartmentUserId) {
        return ordersRepository.findAllOrderOfUserHasApartment(apartmentUserId);
    }

    @Override
    public Iterable<Orders> findAllByUserId(Long users_id) {
        return ordersRepository.findAllByUserId(users_id);
    }

    @Override
    public Iterable<Orders> findAllByApartmentId(Long apartment_id) {
        return ordersRepository.findAllByApartmentId(apartment_id);
    }

    @Override
    public Iterable<Orders> findAllOrderOfApartmentWithPending(long apartmentId) {
        return ordersRepository.findAllOrderOfApartmentWithPending(apartmentId);
    }

    @Override
    public Iterable<Orders> findAllByUsersId(Long id) {
        return ordersRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Orders> findAllByApartment(Long apartmentID) {
        return ordersRepository.findAllByApartment(apartmentID);
    }
}
