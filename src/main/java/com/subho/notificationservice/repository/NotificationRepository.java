package com.subho.notificationservice.repository;


import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.entities.Status;

import java.util.List;

public interface NotificationRepository {

    Notification save(Notification notification);
    Notification findById(String id);
    List<Notification> findByStatus(Status status);

}
