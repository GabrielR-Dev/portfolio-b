package com.example.demo.controller;

import com.example.demo.services.models.dtos.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class emailController {

    //Utilizo la Interfaz para implementar el EmailService
    @Autowired
    com.example.demo.services.interfaces.IEmailServices iEmailServices;
    //Llega el mail al controlador
    @PostMapping("/sendEmail")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {
        //Utilizamos la implementacion de interface IEmailServices

        iEmailServices.sendMail(email);
        return new ResponseEntity<>("Correo enviado exitosamente.", HttpStatus.OK);
    }
}
