package com.notification.notificationservice.decorator;

import com.notification.notificationservice.service.Notification;
import org.springframework.stereotype.Component;

public abstract class NotificationDecorator implements Notification {

    protected final Notification notification;

    protected NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String to,String message) {
        notification.send(to,message); // delegate to wrapped notifier
    }
}
