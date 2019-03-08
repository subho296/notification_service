package com.subho.notificationservice.service.impl;

import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.entities.NotificationType;
import com.subho.notificationservice.entities.Status;
import com.subho.notificationservice.exception.SystemException;
import com.subho.notificationservice.repository.NotificationRepository;
import com.subho.notificationservice.service.NotificationService;
import com.subho.notificationservice.entities.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void addNotification(NotificationRequest notificationRequest) throws SystemException {
        validateNotification(notificationRequest);
        Notification notification = new Notification();
        notification.setNotificationType(NotificationType.EMAIL_NOTIFICATION);
        notification.setNotificationRequest(notificationRequest);
        notificationRepository.save(notification);

    }

    @Override
    public List<Notification> findPendingNotification() {

        return notificationRepository.findByStatus(Status.ENQUE);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    private boolean validateNotification(NotificationRequest notificationRequest) throws SystemException {
        return true;
    }
}
