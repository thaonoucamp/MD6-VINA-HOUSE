package com.example.rent_house.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional findById(Long id);

    T save(T t);

    void delete(Long id);
}
