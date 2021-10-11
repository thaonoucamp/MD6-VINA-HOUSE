package com.example.rent_house.controller;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.ApartmentDayInOrder;
import com.example.rent_house.service.apartmentDayInOrder.ApartmentDayInOrderServiceImp;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/apartmentdayinorder")
@CrossOrigin("*")
public class ControllerApartmentDayInOrder {
    @Autowired
    ApartmentDayInOrderServiceImp apartmentDayInOrderServiceImp;

    @GetMapping("")
    public ResponseEntity<List<ApartmentDayInOrder>> showListApartmentDayInOrder() {
        return new ResponseEntity(apartmentDayInOrderServiceImp.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentDayInOrder> findApartmentDayInOrderById(@PathVariable long id) {
        return new ResponseEntity(apartmentDayInOrderServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApartmentDayInOrder> createApartmentDayInOrder(@RequestBody ApartmentDayInOrder apartmentDayInOrder) {
        return new ResponseEntity(apartmentDayInOrderServiceImp.save(apartmentDayInOrder), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApartmentDayInOrder> editApartmentDayInOrder(@PathVariable long id, @RequestBody ApartmentDayInOrder apartmentDayInOrder) {
        Optional<ApartmentDayInOrder> apartmentDayInOrderOptional = apartmentDayInOrderServiceImp.findById(id);
        if (!apartmentDayInOrderOptional.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(apartmentDayInOrderServiceImp.save(apartmentDayInOrder), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApartmentDayInOrder> deleteApartmentDayInOrder(@PathVariable long id) {
        apartmentDayInOrderServiceImp.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
