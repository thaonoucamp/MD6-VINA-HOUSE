package com.example.rent_house.controller;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.service.apartment.ApartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartment")
@CrossOrigin("*")
public class ControllerApartment {
    @Autowired
    ApartmentServiceImp apartmentServiceImp;

    @GetMapping("")
    public ResponseEntity<List<Apartment>> showListApartment() {
        return new ResponseEntity(apartmentServiceImp.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> findApartmentById(@PathVariable long id) {
        return new ResponseEntity(apartmentServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        return new ResponseEntity(apartmentServiceImp.save(apartment), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartment> editApartment(@RequestBody Apartment apartment, @PathVariable Long id) {
        Optional<Apartment> apartmentOptional = apartmentServiceImp.findById(id);
        if (!apartmentOptional.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(apartmentServiceImp.save(apartment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Apartment> deleteApartment(@PathVariable long id) {
        apartmentServiceImp.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
