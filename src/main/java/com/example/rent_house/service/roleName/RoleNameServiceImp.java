package com.example.rent_house.service.roleName;

import com.example.rent_house.model.RoleName;
import com.example.rent_house.repository.IRepositoryRoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleNameServiceImp implements IRoleNameService {
    @Autowired
    IRepositoryRoleName repositoryRoleName;

    @Override
    public Iterable<RoleName> getAll() {
        return repositoryRoleName.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryRoleName.findById(id);
    }

    @Override
    public RoleName save(RoleName roleName) {
        return repositoryRoleName.save(roleName);
    }

    @Override
    public void delete(Long id) {
        repositoryRoleName.deleteById(id);
    }
}
