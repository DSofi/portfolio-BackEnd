package com.probando.segunda.controller;

import com.probando.segunda.model.Persona;
import com.probando.segunda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/personas")
    @ResponseBody
    public List<Persona> getPersonas(){
        return persoServ.getPersonas();
    }
    
    @PostMapping ("/personas")
    @ResponseBody
    public Persona createPersona(@RequestBody Persona pers){
        return persoServ.savePersona(pers);
    }
    
    @DeleteMapping ("/personas/{id}")
    @ResponseBody
    public List<Persona> deletePersona (@PathVariable Long id){
        return persoServ.deletePersona(id);
    }
    
    @PutMapping ("personas/{id}")
    @ResponseBody
    public Persona editPersona (@PathVariable Long id, @RequestBody Persona persona){
        Persona pers = persoServ.findPersona(id);
        pers.setNombre(persona.getNombre());
        pers.setTitulo(persona.getTitulo());
        pers.setSobreMi(persona.getSobreMi());
        pers.setFoto(persona.getFoto());
        pers.setImagenCover(persona.getImagenCover());
        pers.setLink(persona.getLink());
        pers.setEditar(false);
        return persoServ.savePersona(pers);
    }
    
    @GetMapping("personas/{id}")
    @ResponseBody
    public Persona findPersona(@PathVariable Long id){
        return persoServ.findPersona(id);
    }
    
}
