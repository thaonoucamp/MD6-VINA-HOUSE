package com.example.rent_house.service.apartmentDayInOrder;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.ApartmentDayInOrder;
import com.example.rent_house.repository.IRepositoryApartmentDayInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentDayInOrderServiceImp implements IApartmentDayInOrderService {
    @Autowired
    IRepositoryApartmentDayInOrder repositoryApartmentDayInOrder;

    @Override
    public Iterable<ApartmentDayInOrder> getAll() {
        return repositoryApartmentDayInOrder.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryApartmentDayInOrder.findById(id);
    }

    @Override
    public ApartmentDayInOrder save(ApartmentDayInOrder apartmentDayInOrder) {
        return repositoryApartmentDayInOrder.save(apartmentDayInOrder);
    }

    @Override
    public void delete(Long id) {
        repositoryApartmentDayInOrder.deleteById(id);
    }
}
