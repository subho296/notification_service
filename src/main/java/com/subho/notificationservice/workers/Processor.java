package com.subho.notificationservice.workers;

import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.entities.NotificationType;

public interface Processor {

    NotificationType getNotificationType();

    void process(Notification notification);
}
