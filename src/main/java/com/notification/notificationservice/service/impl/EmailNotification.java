package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.service.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending EMAIL to " + to + ": " + message);
    }
}
