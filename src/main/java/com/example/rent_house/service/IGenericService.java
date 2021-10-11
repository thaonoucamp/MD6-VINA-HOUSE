package com.example.rent_house.service;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Image;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> getAll();

    Optional findById(Long id);

    T save(T t);

    void delete(Long id);
}
