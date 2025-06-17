package com.notification.notificationservice.factory;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.decorator.LoggingNotification;
import com.notification.notificationservice.decorator.PushNotification;
import com.notification.notificationservice.decorator.SmsNotification;
import com.notification.notificationservice.service.Notification;
import com.notification.notificationservice.service.impl.EmailNotification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationDecoratorFactory {
    private final EmailNotification emailNotification;

    public NotificationDecoratorFactory(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Notification getNotification(List<NotificationType> types) {
        Notification notification = emailNotification;

        for (NotificationType type : types) {
            switch (type) {
                case SMS:
                    notification = new SmsNotification(notification);
                    break;
                case PUSH:
                    notification = new PushNotification(notification);
                    break;
                case LOG:
                    notification = new LoggingNotification(notification);
                    break;
                default:
                    break;
            }
        }

        return notification;

    }
}
