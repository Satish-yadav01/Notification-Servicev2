package com.notification.notificationservice.controller;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public String sendNotification(
            @RequestParam NotificationType type,
            @RequestParam String to,
            @RequestParam String message) {

        notificationService.notifyUser(type, to, message);
        return "Notification Sent via " + type;
    }
}

