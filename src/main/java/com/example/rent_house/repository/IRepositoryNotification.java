package com.example.rent_house.repository;

import com.example.rent_house.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryNotification extends CrudRepository<Notification, Long> {
}
