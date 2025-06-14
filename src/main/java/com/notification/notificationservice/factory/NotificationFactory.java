package com.notification.notificationservice.factory;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.service.Notification;
import com.notification.notificationservice.service.impl.EmailNotification;
import com.notification.notificationservice.service.impl.PushNotification;
import com.notification.notificationservice.service.impl.SMSNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    @Autowired
    private ApplicationContext context;

    public Notification getNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> context.getBean(EmailNotification.class);
            case SMS -> context.getBean(SMSNotification.class);
            case PUSH -> context.getBean(PushNotification.class);
            default -> throw new IllegalArgumentException("Unknown notification type");
        };
    }
}

