package com.example.rent_house.controller;

import com.example.rent_house.model.Users;
import com.example.rent_house.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUsersService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<Iterable<Users>> findAll() {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        Optional<Users> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Users> add(@RequestBody Users user) {
        return new ResponseEntity(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/edit-user/{id}")
    public ResponseEntity<Users> updateRecoveredUser(@PathVariable Long id, @RequestBody Users user) {
        return new ResponseEntity(userService.save(user), HttpStatus.OK);
    }


    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Users> deleteById(@PathVariable Long id) {
        Optional<Users> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
    }

}