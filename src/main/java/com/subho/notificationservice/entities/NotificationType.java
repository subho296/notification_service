package com.subho.notificationservice.entities;

import com.subho.notificationservice.workers.EmailProcessor;

public enum NotificationType {

    EMAIL_NOTIFICATION(EmailProcessor.class), PUSH_NOTIFICATION(null);

    Class processorClass;

    NotificationType(Class clazz) {
        this.processorClass = clazz;
    }

    public Class getProcessorClass(){
        return processorClass;
    }

    }
