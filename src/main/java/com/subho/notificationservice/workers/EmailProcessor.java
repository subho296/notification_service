package com.subho.notificationservice.workers;

import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.entities.NotificationType;
import com.subho.notificationservice.entities.Status;
import com.subho.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailProcessor implements Processor{

    private NotificationType notificationType = NotificationType.EMAIL_NOTIFICATION;

    @Autowired
    private NotificationService notificationService;


    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

    @Override
    public void process(Notification notification) {
        notification.setStatus(Status.PROCESSED);
        notificationService.update(notification);
        System.out.println("Email sent");
    }



}
