package com.subho.notificationservice.workers;

import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ServiceWorker implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ServiceWorker.class);
    private NotificationService notificationService;
    private ApplicationContext appContext;

    public ServiceWorker(NotificationService notificationService, ApplicationContext appContext) {
        this.notificationService = notificationService;
        this.appContext = appContext;
    }

    @Override
    public void run() {
        logger.info("Starting the service worker thread");
        try {
            while (true) {

                Thread.sleep(10 * 1000);


                List<Notification> notifications = readNextNotifications();
                logger.info("Found unprocessed notifications : " + notifications.size());
                notifications.forEach(notification -> {
                    Processor processor = (Processor) appContext.getBean(notification.getNotificationType().getProcessorClass());
                    processor.process(notification);
                });


            }
        } catch (InterruptedException e) {
            logger.error("Error in service worker thread",e);
        }
    }

    private List<Notification> readNextNotifications() {
        return notificationService.findPendingNotification();
    }
}
