package com.example.rent_house.repository;

import com.example.rent_house.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryUsers extends CrudRepository<Users, Long> {
}
