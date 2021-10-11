package com.example.rent_house.service.notification;

import com.example.rent_house.model.Apartment;
import com.example.rent_house.model.Notification;
import com.example.rent_house.repository.IRepositoryNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImp implements INotificationService {
    @Autowired
    IRepositoryNotification repositoryNotification;

    @Override
    public Iterable<Notification> getAll() {
        return repositoryNotification.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return repositoryNotification.findById(id);
    }

    @Override
    public Notification save(Notification notification) {
        return repositoryNotification.save(notification);
    }

    @Override
    public void delete(Long id) {
        repositoryNotification.deleteById(id);
    }
}
