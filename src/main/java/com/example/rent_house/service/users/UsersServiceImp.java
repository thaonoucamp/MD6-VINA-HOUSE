package com.example.rent_house.service.users;

import com.example.rent_house.model.Roles;
import com.example.rent_house.model.Users;
import com.example.rent_house.repository.IRepositoryRoles;
import com.example.rent_house.repository.IRepositoryUsers;
import com.example.rent_house.security.UserPrincipal;
import com.example.rent_house.service.roles.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.example.rent_house.model.RoleName.ROLE_USER;

@Service
public class UsersServiceImp implements IUsersService {
    @Autowired
    private IRolesService rolesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public void delete(Long id) {
        repositoryUsers.deleteById(id);
    }

    @Override
    public Users findByUsername(String username) {
        return repositoryUsers.findUsersByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repositoryUsers.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repositoryUsers.existsByEmail(email);
    }

    @Override
    public Users save(Users users) {
        Roles role = rolesService.findByName(ROLE_USER.toString());
        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        users.setRoles(roles);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return repositoryUsers.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repositoryUsers.findUsersByUsername(username);
        return UserPrincipal.build(user);
    }
}
