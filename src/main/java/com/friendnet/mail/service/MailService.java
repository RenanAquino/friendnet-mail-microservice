package com.friendnet.mail.service;

import com.friendnet.mail.dto.MailDTO;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(MailDTO data) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(data.email());
        message.setSubject(data.subject());
        message.setText(data.message());

        mailSender.send(message);
    }
}