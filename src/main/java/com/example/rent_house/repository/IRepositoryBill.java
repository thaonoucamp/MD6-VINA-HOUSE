package com.example.rent_house.repository;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Bill;
import com.example.rent_house.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface IRepositoryBill extends CrudRepository<Bill, Long> {
    public double totalBill(Bill bill);
    }
