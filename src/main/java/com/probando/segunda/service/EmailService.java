
package com.probando.segunda.service;

import com.probando.segunda.model.Email;
import com.probando.segunda.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    
    @Autowired
    private MailSender mailSender;
    
    @Autowired
    private Environment env;
    
    String emailEmail = env.getProperty("EMAIL_EMAIL");
    
    @Override
    public ResponseEntity<RestResponse> enviarEmail(Email email){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo( emailEmail);
        mensaje.setFrom(email.getFromEmail());
        mensaje.setSubject("email de : " + email.getNombre());
        mensaje.setText("Mensaje : \n" + email.getMensaje() + "\nde : " + email.getFromEmail());
        mailSender.send(mensaje);        
        
        SimpleMailMessage confMail = new SimpleMailMessage();
        confMail.setTo(email.getFromEmail());
        confMail.setFrom( emailEmail);
        confMail.setSubject("Su email ha sido enviado correctamente");
        confMail.setText("Esto es un mensaje de confirmación, gracias por ver mi portfolio y escribirme, pronto estaré respondiendo.\n \nSaludos, \nSofi . ");
        mailSender.send(confMail);
        
        return new ResponseEntity<>(new RestResponse("success", "Email enviado correctamente"), HttpStatus.OK);
    }    
}
