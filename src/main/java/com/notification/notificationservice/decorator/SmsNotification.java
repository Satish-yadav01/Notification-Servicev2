package com.notification.notificationservice.decorator;

import com.notification.notificationservice.service.Notification;
import org.springframework.stereotype.Component;

public class SmsNotification extends NotificationDecorator{

    public SmsNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String to, String message) {
        super.send(to, message);
        System.out.println("Sending SMS Notification: " + message);
    }
}
