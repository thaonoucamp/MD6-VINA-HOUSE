package com.example.rent_house.repository;

import com.example.rent_house.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryComment extends CrudRepository<Comment, Long> {
}
