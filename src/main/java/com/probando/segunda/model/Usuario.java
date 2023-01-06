
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotNull 
    private String user;
    
    @NotNull 
    private String password;
     
    private String email;
    private boolean puedeEditar;
  
    public Usuario() {
    }

    public Usuario(Long id, String user, String email, String password, boolean puedeEditar) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.password = password;
        this.puedeEditar = puedeEditar;
    }    
}
