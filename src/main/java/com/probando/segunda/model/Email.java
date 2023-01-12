
package com.probando.segunda.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Email {
    
    @NotNull
    private String fromEmail;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String mensaje;   

    public Email() {
    }

    public Email(String fromEmail, String nombre, String mensaje) {
        this.fromEmail = fromEmail;
        this.nombre = nombre;
        this.mensaje = mensaje;
    }
}