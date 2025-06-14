package com.notification.notificationservice.service;

import org.springframework.stereotype.Component;

@Component
public class SmtpService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to + " with subject " + subject + " and body " + body);
    }
}
