package com.example.rent_house.controller;

import com.example.rent_house.models.Notification;
import com.example.rent_house.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationControllerAPI {
    @Autowired
    INotificationService iNotificationService;

    @GetMapping("/findAllByUser/{userId}")
    public ResponseEntity<Iterable<Notification>> findAllByUser(@PathVariable long userId) {
        return new ResponseEntity<>(iNotificationService.findAllByUser(userId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Notification> save(@RequestBody Notification notification) {
        return new ResponseEntity<>(iNotificationService.save(notification), HttpStatus.CREATED);
    }
}
