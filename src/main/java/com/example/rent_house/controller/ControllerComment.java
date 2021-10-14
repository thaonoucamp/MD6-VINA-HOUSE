package com.example.rent_house.controller;

import com.example.rent_house.model.ApartmentDayInOrder;
import com.example.rent_house.model.Comment;
import com.example.rent_house.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class ControllerComment {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public ResponseEntity<List<Comment>> showListApartmentDayInOrder() {
        return new ResponseEntity(commentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findApartmentDayInOrderById(@PathVariable long id) {
        return new ResponseEntity(commentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Comment> createApartmentDayInOrder(@RequestBody Comment apartmentDayInOrder) {
        return new ResponseEntity(commentService.save(apartmentDayInOrder), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApartmentDayInOrder> editApartmentDayInOrder(@PathVariable long id, @RequestBody Comment apartmentDayInOrder) {
        Optional<Comment> apartmentDayInOrderOptional = commentService.findById(id);
        if (!apartmentDayInOrderOptional.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(commentService.save(apartmentDayInOrder), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApartmentDayInOrder> deleteApartmentDayInOrder(@PathVariable long id) {
        commentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
