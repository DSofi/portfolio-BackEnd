
package com.probando.segunda.controller;

import com.probando.segunda.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    
    @Autowired
    private MailSender mailSender;
    
    @PostMapping("/enviar-mail")
    public String sendConfirmacionEmail(@RequestBody Email email){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo("ap.dsofi@gmail.com");
        mensaje.setFrom(email.getFromEmail());
        mensaje.setSubject("email de : " + email.getNombre());
        mensaje.setText("Mensaje : \n" + email.getMensaje() + "\nDe : " + email.getFromEmail());
        mailSender.send(mensaje);
        return "OK";
    }
    
}
