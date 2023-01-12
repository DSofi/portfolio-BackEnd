
package com.probando.segunda.service;

import com.probando.segunda.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    
    @Autowired
    private MailSender mailSender;
    
    @Override
    public String enviarEmail(Email email){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo("ap.dsofi@gmail.com");
        mensaje.setFrom(email.getFromEmail());
        mensaje.setSubject("email de : " + email.getNombre());
        mensaje.setText("Mensaje : \n" + email.getMensaje() + "\nde : " + email.getFromEmail());
        mailSender.send(mensaje);        
        
        SimpleMailMessage confMail = new SimpleMailMessage();
        confMail.setTo(email.getFromEmail());
        confMail.setFrom("ap.dsofi@gmail.com");
        confMail.setSubject("Su email ha sido enviado correctamente");
        confMail.setText("Esto es un mensaje de confirmación, gracias por ver mi portfolio y escribirme, pronto estaré respondiendo.\n \nSaludos, \nSofi . ");
        mailSender.send(confMail);
        
        return "Email enviado correctamente";
    }
    
}
