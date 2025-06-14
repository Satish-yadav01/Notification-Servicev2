package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.service.Notification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class SMSNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
