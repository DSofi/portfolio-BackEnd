
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
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String imagen;    
    private int orden;
    
    @ManyToOne
    @JoinColumn (name = "tiposkill_id")
    private Tiposkill tiposkill;

    public Skill() {
    }

    public Skill(Long id, String nombre, String imagen, int orden, Tiposkill tiposkill) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.orden = orden;
        this.tiposkill = tiposkill;
    }    
}
