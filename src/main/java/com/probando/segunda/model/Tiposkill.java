
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tiposkill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @OneToMany(mappedBy = "tiposkill")
    private List<Skill> skills;

    public Tiposkill() {
    }

    public Tiposkill(Long id, String nombre, List<Skill> skills) {
        this.id = id;
        this.nombre = nombre;
        this.skills = skills;
    }
}
