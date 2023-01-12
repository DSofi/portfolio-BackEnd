
package com.probando.segunda.controller;

import com.probando.segunda.model.Email;
import com.probando.segunda.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    
    @Autowired
    private EmailService emailServ;
    
    @PostMapping("/enviar-mail")
    public String enviarEmail(@RequestBody Email email){
        return emailServ.enviarEmail(email);
    }
    
}