package com.plourlbackend.service;

import com.plourlbackend.dao.NotificationRepository;
import com.plourlbackend.domain.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification getNotification(Long id) {
        return notificationRepository.findOne(id);
    }

    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification  deleteNotification(Long id) {
        Optional<Notification> notificationOptional = Optional.ofNullable(notificationRepository.findOne(id));
        if (notificationOptional.isPresent()) {
            notificationRepository.delete(notificationOptional.get().getId());
            return notificationOptional.get();
        } else {
            throw new IllegalArgumentException("La notificacion no existe");
        }
    }

}
