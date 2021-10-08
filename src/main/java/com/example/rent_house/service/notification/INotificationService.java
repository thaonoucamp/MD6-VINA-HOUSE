package com.example.rent_house.service.notification;


import com.example.rent_house.models.Notification;
import com.example.rent_house.service.IGenericService;

import java.util.Optional;

public interface INotificationService extends IGenericService<Notification> {
    Optional<Notification> findById(long id);

    void delete(long id);

    Iterable<Notification> findAllByUser(long userId);

}
