
package com.probando.segunda.service;

import com.probando.segunda.model.Email;
import com.probando.segunda.model.RestResponse;
import org.springframework.http.ResponseEntity;

public interface IEmailService {
    public ResponseEntity<RestResponse> enviarEmail(Email email);
    
}
