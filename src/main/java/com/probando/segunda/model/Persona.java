
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotNull 
    @Size(min=3, max=50)
    private String nombre;
    
    @NotNull 
    @Size(min=3, max=50)
    private String titulo;
    
    @NotNull
    @Size(min=3, max=900)
    private String sobreMi;
    
    private String foto; 
    private String imagenCover; 
    private String link;
    private boolean editar; 
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String titulo, String sobreMi, String foto, String imagenCover, String link, boolean editar) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.foto = foto;
        this.imagenCover = imagenCover;
        this.link = link;
        this.editar = editar;
    }        
}
