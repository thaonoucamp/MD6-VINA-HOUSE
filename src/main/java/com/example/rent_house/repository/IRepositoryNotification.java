package com.example.rent_house.repository;

import com.example.rent_house.models.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryNotification extends PagingAndSortingRepository<Notification,Long> {
    @Query(value = "select * from notification where user_id=?1 ",nativeQuery = true)
    Iterable<Notification> findAllByUser(long userId);
}
