package com.example.rent_house.service.bill;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Bill;
import com.example.rent_house.model.Users;
import com.example.rent_house.repository.IRepositoryApartment;
import com.example.rent_house.repository.IRepositoryBill;
import com.example.rent_house.repository.IRepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class BillServiceImp implements IBillService {
    @Autowired
    private IRepositoryBill iRepositoryBill;
//    @Autowired
//    private IRepositoryApartment repositoryApartment;

    @Override
    public Iterable<Bill> getAll() {
        return iRepositoryBill.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return iRepositoryBill.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return iRepositoryBill.save(bill);
    }

    @Override
    public void delete(Long id) {
        iRepositoryBill.deleteById(id);
    }

//    @Override
//    public double totalBill(LocalDate startDay, LocalDate endDay, Long id) {
//        Apartment apartment = repositoryApartment.findById(id).get();
//        final long days = ChronoUnit.DAYS.between(startDay, endDay);
//        double total = days * apartment.getPrice();
//        return total;
//    }
}
