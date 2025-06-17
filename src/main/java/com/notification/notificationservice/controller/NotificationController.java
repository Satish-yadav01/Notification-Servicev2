package com.notification.notificationservice.controller;

import com.notification.notificationservice.constant.NotificationType;
import com.notification.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<String> sendNotification(@RequestParam List<NotificationType> types,
               @RequestParam String to,
               @RequestParam String message) {
        notificationService.notify(types,to,message);
        return ResponseEntity.ok("Notification sent via: " + types);
    }
}

