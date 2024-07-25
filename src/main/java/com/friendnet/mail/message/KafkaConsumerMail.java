package com.friendnet.mail.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.friendnet.mail.dto.MailDTO;
import com.friendnet.mail.service.MailService;

@Component
public class KafkaConsumerMail {

    @Autowired
    private MailService mailService;

    @KafkaListener(topics = "mail_topic", groupId = "email-consumers")
    public void listen(MailDTO data) {
        System.out.println("Consumer message: " + data);
        mailService.sendEmail(data);
    }
}
