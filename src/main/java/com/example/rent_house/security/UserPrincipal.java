package com.example.rent_house.security;

import com.example.rent_house.model.Roles;
import com.example.rent_house.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> roles;
    public UserPrincipal(Long id, String username, String password,
                         Collection<? extends GrantedAuthority> roles){
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    public static UserPrincipal build(Users user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
        return new UserPrincipal( user.getId(), user.getUsername(),user.getPassword(), authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}