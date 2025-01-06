package com.example.demo.services.interfaces;

import com.example.demo.services.models.dtos.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailServices {
    public void sendMail(EmailDTO email) throws MessagingException;
}
