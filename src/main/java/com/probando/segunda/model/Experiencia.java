
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tiempo;
    private String titulo;
    private String descripcion;
    private String otrasNotas;
    private String imagen;   
    private boolean editar;
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Experiencia() {
    }

    public Experiencia(Long id, String tiempo, String titulo, String descripcion, String otrasNotas, String imagen, boolean editar, Persona persona) {
        this.id = id;
        this.tiempo = tiempo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.otrasNotas = otrasNotas;
        this.imagen = imagen;
        this.editar = editar;
        this.persona = persona;
    }

    

    

   

    
    
    
}
