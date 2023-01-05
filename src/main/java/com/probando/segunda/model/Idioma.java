
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Idioma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String tiempo;
    @NotNull
    private String titulo;
    
    private String descripcion;
    private String otrasNotas;
    private String imagen;   
    private boolean editar;
    private int orden;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Idioma() {
    }

    public Idioma(Long id, String tiempo, String titulo, String descripcion, String otrasNotas, String imagen, boolean editar, int orden, Persona persona) {
        this.id = id;
        this.tiempo = tiempo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.otrasNotas = otrasNotas;
        this.imagen = imagen;
        this.editar = editar;
        this.orden = orden;
        this.persona = persona;
    }    
}
    

    

