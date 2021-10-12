package com.example.rent_house.controller;

import com.example.rent_house.model.Comment;
import com.example.rent_house.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("comments")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public ResponseEntity<List<Comment>> getAllComment(){
        return new ResponseEntity(commentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id){
        return new ResponseEntity(commentService.findById(id),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Comment> create(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody Comment comment){
       Comment commentOld = (Comment) commentService.findById(id).get();
       comment.setId(commentOld.getId());
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
