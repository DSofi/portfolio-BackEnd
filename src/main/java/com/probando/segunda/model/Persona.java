
package com.probando.segunda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @NotNull 
    private String nombre;
    
    @NotNull 
    private String sobreMi;
     
     @NotNull 
    private String foto;
     
     @NotNull 
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
