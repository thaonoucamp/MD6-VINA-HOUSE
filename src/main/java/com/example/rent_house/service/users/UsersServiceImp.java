package com.example.rent_house.service.users;

import com.example.rent_house.model.Users;
import com.example.rent_house.repository.IRepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImp implements IUsersService {
    @Autowired
    IRepositoryUsers repositoryUsers;

    @Override
    public Iterable<Users> getAll() {
        return repositoryUsers.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryUsers.findById(id);
    }

    @Override
    public Users save(Users users) {
        return repositoryUsers.save(users);
    }

    @Override
    public void delete(Long id) {
        repositoryUsers.deleteById(id);
    }
}
