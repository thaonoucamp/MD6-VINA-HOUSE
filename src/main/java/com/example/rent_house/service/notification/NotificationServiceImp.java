package com.example.rent_house.service.notification;

import com.example.rent_house.models.Notification;
import com.example.rent_house.repository.IRepositoryNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImp implements INotificationService {
    @Autowired
    private IRepositoryNotification iRepositoryNotification;

    @Override
    public Iterable<Notification> findAll() {
        return iRepositoryNotification.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Notification> findById(long id) {
        return iRepositoryNotification.findById(id);
    }

    @Override
    public Notification save(Notification notification) {
        return iRepositoryNotification.save(notification);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(long id) {
        iRepositoryNotification.deleteById(id);
    }

    @Override
    public Iterable<Notification> findAllByUser(long userId) {
        return iRepositoryNotification.findAllByUser(userId);
    }
}
