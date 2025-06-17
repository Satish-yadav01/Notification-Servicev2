package com.notification.notificationservice.service;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.factory.NotificationDecoratorFactory;
import com.notification.notificationservice.factory.NotificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationFactory factory;
    private final NotificationDecoratorFactory notificationDecoratorFactory;


    @Autowired
    public NotificationService(NotificationFactory factory, NotificationDecoratorFactory notificationDecoratorFactory) {
        this.factory = factory;
        this.notificationDecoratorFactory = notificationDecoratorFactory;
    }

    public void notifyUser(NotificationType type, String to, String message) {
        Notification notification = factory.getNotification(type);
        notification.send(to, message);
    }

    public void notify(List<NotificationType> types,String to, String message){
        Notification notifier = notificationDecoratorFactory.getNotification(types);
        notifier.send(to,message);
    }
}
