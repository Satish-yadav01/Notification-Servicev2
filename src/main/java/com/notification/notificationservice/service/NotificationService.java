package com.notification.notificationservice.service;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.factory.NotificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationFactory factory;

    @Autowired
    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public void notifyUser(NotificationType type, String to, String message) {
        Notification notification = factory.getNotification(type);
        notification.send(to, message);
    }
}
