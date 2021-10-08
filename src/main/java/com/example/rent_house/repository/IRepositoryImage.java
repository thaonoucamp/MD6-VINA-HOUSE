package com.example.rent_house.repository;


import com.example.rent_house.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryImage extends CrudRepository<Image, Long> {
}
