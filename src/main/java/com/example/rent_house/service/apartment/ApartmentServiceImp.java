package com.example.rent_house.service.apartment;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Bill;
import com.example.rent_house.repository.IRepositoryApartment;
import com.example.rent_house.repository.IRepositoryBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class ApartmentServiceImp implements IApartmentService {
    @Autowired
    private IRepositoryApartment repositoryApartment;

    @Override
    public Iterable<Apartment> getAll() {
        return repositoryApartment.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryApartment.findById(id);
    }

    @Override
    public Apartment save(Apartment apartment) {
        return repositoryApartment.save(apartment);
    }

    @Override
    public void delete(Long id) {
        repositoryApartment.deleteById(id);
    }

}
