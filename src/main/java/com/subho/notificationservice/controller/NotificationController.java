package com.subho.notificationservice.controller;

import com.subho.notificationservice.entities.EmailRequest;
import com.subho.notificationservice.exception.SystemException;
import com.subho.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/emails/")
    public void sendEmail(@RequestBody EmailRequest emailRequest){

        try {
            notificationService.addNotification(emailRequest);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        System.out.println("Inside Email");

    }

    @PostMapping("/pushnotifications/")
    public void sendPushNotification(){
        System.out.println("Inside push");

    }
}
