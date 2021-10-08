package com.example.rent_house.repository;

import com.example.rent_house.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRepositoryUsers extends CrudRepository<Users, Long> {
     Users findByUsername(String username);
}
