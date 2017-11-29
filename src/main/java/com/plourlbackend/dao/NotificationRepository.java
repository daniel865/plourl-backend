package com.plourlbackend.dao;

import com.plourlbackend.domain.Notification;
import com.plourlbackend.domain.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long>, PagingAndSortingRepository<Notification, Long> {
}
