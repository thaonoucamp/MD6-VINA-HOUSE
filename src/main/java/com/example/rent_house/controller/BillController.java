package com.example.rent_house.controller;

import com.example.rent_house.model.Bill;
import com.example.rent_house.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private IBillService billService;

    @PostMapping("")
    public ResponseEntity<Bill> post(@RequestBody Bill bill) {
        return new ResponseEntity<>(billService.save(bill), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> showBill(@PathVariable Long id) {
        return new ResponseEntity(billService.findById(id),HttpStatus.OK);
    }
}
