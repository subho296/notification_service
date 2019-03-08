package com.subho.notificationservice.workers;

import com.subho.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class NotificationThread {


    private static final Logger logger = LoggerFactory.getLogger(NotificationThread.class);

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private ApplicationContext applicationContext;

    private final ExecutorService executor =  Executors.newSingleThreadExecutor();

    public final void startNotificationWorker(){


        logger.info("Starting the service executor");
        executor.execute(new ServiceWorker(notificationService, applicationContext));

    }



}
