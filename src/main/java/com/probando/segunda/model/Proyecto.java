
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String fecha;
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Proyecto() {
    }

    public Proyecto(Long id, String fecha, String titulo) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
    }
        
}
