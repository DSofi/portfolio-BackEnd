
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @NotNull 
    @Size(min=3, max=50)
    private String nombre;
    
    @NotNull
    @Size(min=3, max=250)
    private String sobreMi;
    
    private String foto;
 
    private String link;
    
    @OneToOne(optional = true)
    private Usuario usuario;
    
    @OneToMany(mappedBy = "persona")
    private List<Estudio> estudios;
    
    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String sobreMi, String foto, String link, List<Estudio> estudios) {
        this.id = id;
        this.nombre = nombre;
        this.sobreMi = sobreMi;
        this.foto = foto;
        this.link = link;
        this.estudios = estudios;
    }
        
}
