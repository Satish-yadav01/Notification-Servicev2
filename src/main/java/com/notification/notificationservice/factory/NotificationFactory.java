package com.notification.notificationservice.factory;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.service.Notification;
import com.notification.notificationservice.service.impl.EmailNotification;
import com.notification.notificationservice.service.impl.PushNotification;
import com.notification.notificationservice.service.impl.SMSNotification;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    public Notification getNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case PUSH -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type");
        };
    }
}

