
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotNull 
    @NotBlank
    @Size(min = 5, max = 12)
    private String user;
    
    @NotNull 
    @NotBlank
    @Size(min = 8, max = 12)    
    private String password;
     
    private String email;
    private boolean puedeEditar;
    
    @OneToOne
    private Persona persona;

    public Usuario() {
    }

    public Usuario(Long id, String user, String email, String password, boolean puedeEditar, Persona persona) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.password = password;
        this.puedeEditar = puedeEditar;
        this.persona = persona;
    }    
}
