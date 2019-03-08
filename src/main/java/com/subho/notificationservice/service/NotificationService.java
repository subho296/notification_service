package com.subho.notificationservice.service;

import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.entities.NotificationRequest;
import com.subho.notificationservice.exception.SystemException;

import java.util.List;

public interface NotificationService {

    void addNotification(NotificationRequest notificationRequest) throws SystemException;
    List<Notification> findPendingNotification();

    Notification update(Notification notification);
}
