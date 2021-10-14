package com.example.rent_house.controller;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Bill;
import com.example.rent_house.model.Image;
import com.example.rent_house.model.Users;
import com.example.rent_house.service.apartment.ApartmentServiceImp;
import com.example.rent_house.service.apartment.IApartmentService;
import com.example.rent_house.service.bill.IBillService;
import com.example.rent_house.service.image.IImageService;
import com.example.rent_house.service.image.ImageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartment")
@CrossOrigin("*")
public class ControllerApartment {
    @Autowired
    private IApartmentService iApartmentService;
    @Autowired
    private IImageService iImageService;
    @Autowired
    private IBillService iBillService;

    @GetMapping("")
    public ResponseEntity<List<Apartment>> showListApartment() {
        return new ResponseEntity(iApartmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> findApartmentById(@PathVariable long id) {
        return new ResponseEntity(iApartmentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        iApartmentService.save(apartment);
        if (apartment.getImages() != null) {
            for (Image image : apartment.getImages()) {
                image.setApartmentImage(apartment);
                iImageService.save(image);
            }
        }
        return new ResponseEntity(iApartmentService.save(apartment), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartment> editApartment(@RequestBody Apartment apartment, @PathVariable Long id) {
        Optional<Apartment> apartmentOptional = iApartmentService.findById(id);
        if (!apartmentOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        iApartmentService.save(apartment);
        if (apartment.getImages() != null) {
            for (Image image : apartment.getImages()) {
                image.setApartmentImage(apartment);
                iImageService.save(image);
            }
        }
        return new ResponseEntity(iApartmentService.save(apartment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Apartment> deleteApartment(@PathVariable long id) {
        iApartmentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
//
//    @GetMapping("/totalBill")
//    public ResponseEntity<Double> showBill(@RequestBody Bill bill) {
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
