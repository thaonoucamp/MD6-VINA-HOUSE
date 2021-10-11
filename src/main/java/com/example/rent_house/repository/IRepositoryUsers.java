package com.example.rent_house.repository;

import com.example.rent_house.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IRepositoryUsers extends CrudRepository<Users, Long> {
     @Query(value = "SELECT u from Users u where u.username =:username")
     Users findUsersByUsername(@Param("username") String username);
     Boolean existsByUsername(String username);
     Boolean existsByEmail(String email);
}
