package com.example.rent_house.service.apartment;


import com.example.rent_house.models.Apartment;
import com.example.rent_house.repository.IRepositoryApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//public class ApartmentServiceImp implements IApartmentService {
//    @Autowired
//    IRepositoryApartment repositoryApartment;
//
//    @Override
//    public Iterable<Apartment> getAll() {
//        return repositoryApartment.findAll();
//    }
//
//    @Override
//    public Optional findById(Long id) {
//        return repositoryApartment.findById(id);
//    }
//
//    @Override
//    public Apartment save(Apartment apartment) {
//        return repositoryApartment.save(apartment);
//    }
//
//    @Override
//    public void delete(Long id) {
//        repositoryApartment.deleteById(id);
//    }
//}
