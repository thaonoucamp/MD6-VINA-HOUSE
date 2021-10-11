package com.example.rent_house.controller;

import com.example.rent_house.model.RoleName;
import com.example.rent_house.model.Roles;
import com.example.rent_house.model.Users;
import com.example.rent_house.security.*;
import com.example.rent_house.service.roles.IRolesService;
import com.example.rent_house.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class ControllerLogin {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUsersService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody AccountLogin user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Users currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity(new ResponseMessage("no_user"), HttpStatus.NO_CONTENT);
        } else if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity(new ResponseMessage("no_email"), HttpStatus.NO_CONTENT);
        } else {
            Users users = new Users(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getPassword());
            userService.save(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    //1. Tạo ra 1 thằng xác thực khi nhận request

    //2. Nếu đã được xác thực sẽ được lưu lại trong context

    //3. Cấp token cho user khi đã xác thực

    //4. Lấy thông tin của tài khoản đăng nhập
}
