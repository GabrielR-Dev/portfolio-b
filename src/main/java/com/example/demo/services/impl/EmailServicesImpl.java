package com.example.demo.services.impl;

import com.example.demo.services.interfaces.IEmailServices;
import com.example.demo.services.models.dtos.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.naming.Context;
@Service
public class EmailServicesImpl implements IEmailServices {
    private final JavaMailSender javaMailSender;

    public EmailServicesImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    // Utilizamos el metodo de la Interfaz IEmailService
    @Override
    public void sendMail(EmailDTO email) throws MessagingException {
        try {

            // Configuración del mensaje
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

            // Configurar destinatario, asunto y cuerpo del mensaje
            helper.setTo("gabrielomarrolon1996@gmail.com");
            helper.setSubject(email.getnombre() + " " + email.getEmc());  // Aquí puedes poner un asunto fijo o usar uno dinámico
            helper.setText(email.getMensaje());     // El contenido del mensaje que recibe en el DTO

            // Enviar el mensaje
            javaMailSender.send(message);
            System.out.println("Correo enviado correctamente.");
        } catch (Exception e) {
            // Manejo de errores, detallando el mensaje de error
            throw new RuntimeException("Error al enviar correo: " + e.getMessage(), e);
        }
    }
}
