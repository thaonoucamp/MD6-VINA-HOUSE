package com.example.rent_house.repository;


import com.example.rent_house.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface IRepositoryUsers extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
}
