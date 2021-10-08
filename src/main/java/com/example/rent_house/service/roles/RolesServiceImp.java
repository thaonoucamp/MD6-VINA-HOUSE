package com.example.rent_house.service.roles;

import com.example.rent_house.model.Roles;
import com.example.rent_house.repository.IRepositoryRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesServiceImp implements IRolesService {
    @Autowired
    IRepositoryRoles repositoryRoles;

    @Override
    public Iterable<Roles> getAll() {
        return repositoryRoles.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryRoles.findById(id);
    }

    @Override
    public Roles save(Roles roles) {
        return repositoryRoles.save(roles);
    }

    @Override
    public void delete(Long id) {
        repositoryRoles.deleteById(id);
    }

    @Override
    public Roles findByName(String name) {
        return repositoryRoles.findByName(name);
    }
}
