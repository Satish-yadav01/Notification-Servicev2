package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.service.Notification;
import com.notification.notificationservice.service.SmtpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements Notification {
    private static final Logger log = LoggerFactory.getLogger(EmailNotification.class);
    private final SmtpService smtpService;

    public EmailNotification(SmtpService smtpService) {
        this.smtpService = smtpService;
    }

    @Override
    public void send(String to, String message) {
        log.info("Sending email to " + to);
        smtpService.sendEmail(to,message,"body------");
    }
}
