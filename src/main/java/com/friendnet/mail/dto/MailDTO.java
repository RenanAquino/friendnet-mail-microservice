package com.friendnet.mail.dto;

public record MailDTO(
    String email,
    String subject,
    String message
) {
    
}
