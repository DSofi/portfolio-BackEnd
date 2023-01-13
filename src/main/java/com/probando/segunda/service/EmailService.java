
package com.probando.segunda.service;

import com.probando.segunda.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public String sendEmail(Email datos){
        try{
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom("ap.dsofi@gmail.com");
            email.setTo(datos.getFromEmail());
            email.setSubject(datos.getNombre());
            email.setText(datos.getBody());        
           mailSender.send(email);

            return "Mail enviado correctamente"; 
        }
        catch (Exception e) {
            return "Error en el envío del mail";
        }
        
    }
}
