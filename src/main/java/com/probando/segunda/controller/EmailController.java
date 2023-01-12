
package com.probando.segunda.controller;

import com.probando.segunda.model.Email;
import com.probando.segunda.model.RestResponse;
import com.probando.segunda.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    
    @Autowired
    private EmailService emailServ;
    
    @PostMapping("/enviar-mail")
    public ResponseEntity<RestResponse> enviarEmail(@RequestBody Email email){
        return emailServ.enviarEmail(email);
    }
    
}