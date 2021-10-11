package com.example.rent_house.service.users;

import com.example.rent_house.model.Users;
import com.example.rent_house.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsersService extends IGenericService<Users>, UserDetailsService {
     Users findByUsername(String username);
     Boolean existsByUsername(String username);
     Boolean existsByEmail(String email);
}
