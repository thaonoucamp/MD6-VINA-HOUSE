package com.example.rent_house.service.comment;

import com.example.rent_house.model.Comment;
import com.example.rent_house.repository.IRepositoryComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImp implements ICommentService {
    @Autowired
    private IRepositoryComment repositoryComment;

    @Override
    public Iterable<Comment> getAll() {
        return repositoryComment.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryComment.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return repositoryComment.save(comment);
    }

    @Override
    public void delete(Long id) {
        repositoryComment.deleteById(id);
    }
}
