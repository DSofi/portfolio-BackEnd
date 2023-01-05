
package com.probando.segunda.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter @Setter
public class Email {
    
    private String fromEmail;
    private String nombre;
    private String body;

    public Email() {
    }

    public Email(String fromEmail, String nombre, String body) {
        this.fromEmail = fromEmail;
        this.nombre = nombre;
        this.body = body;
    }
    
    
    
}    

