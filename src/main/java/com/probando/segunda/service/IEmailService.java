
package com.probando.segunda.service;

import com.probando.segunda.model.Email;
import org.springframework.http.ResponseEntity;

public interface IEmailService {
    public ResponseEntity<String> enviarEmail(Email email);
    
}
