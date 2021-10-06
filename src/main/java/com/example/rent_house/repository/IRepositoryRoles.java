package com.example.rent_house.repository;

import com.example.rent_house.model.Roles;
import org.springframework.data.repository.CrudRepository;

import javax.management.relation.Role;

public interface IRepositoryRoles extends CrudRepository<Roles, Long> {
}
