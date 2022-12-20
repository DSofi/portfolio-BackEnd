package com.probando.segunda.controller;

import com.probando.segunda.model.Estudio;
import com.probando.segunda.model.Experiencia;
import com.probando.segunda.model.Persona;
import com.probando.segunda.model.Proyecto;
import com.probando.segunda.model.Usuario;
import com.probando.segunda.service.IEstudioService;
import com.probando.segunda.service.IExperienciaService;
import com.probando.segunda.service.IPersonaService;
import com.probando.segunda.service.IProyectoService;
import com.probando.segunda.service.IUsuarioService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class Controller {
    
    // ------------ PERSONA ------------
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/personas")
    @ResponseBody
    public List<Persona> getPersonas(){
        return persoServ.getPersonas();
    }
    
    @PostMapping ("/personas")
    public String createPersona(@RequestBody Persona pers){
        persoServ.savePersona(pers);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/personas/{id}")
    public String deletePersona (@PathVariable Long id){
        persoServ.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping ("personas/{id}")
    public String editPersona (@PathVariable Long id,
                                             @RequestParam("nombre") String nuevoNombre,
                                             @RequestParam("sobreMi") String nuevoSobreMi,
                                             @RequestParam(value = "foto", required = false) String nuevaFoto,
                                             @RequestParam(value = "link", required = false) String nuevoLink)
                                             {
        Persona pers = persoServ.findPersona(id);
        pers.setNombre(nuevoNombre);
        pers.setSobreMi(nuevoSobreMi);
        pers.setFoto(nuevaFoto);
        pers.setLink(nuevoLink);
        persoServ.savePersona(pers);
        return "La persona ha sido editada";
    }
    
    
    
        // ------------ ESTUDIO ------------
    @Autowired
    private IEstudioService estudioServ;
    
    @GetMapping ("/estudios")
    @ResponseBody
    public List<Estudio> getEstudios(){
        return estudioServ.getEstudios();
    }
    
     @PostMapping ("/estudios")
    @ResponseBody
    public Estudio createEstudio(@RequestBody Estudio est){
       return estudioServ.saveEstudio(est);
       
    }
    
    @DeleteMapping ("/estudios/{id}")
    public List<Estudio> deleteEstudio (@PathVariable Long id){
        return estudioServ.deleteEstudio(id);
    }
    
  @PutMapping ("estudios/{id}")
    public String editEstudio (@PathVariable Long id,
                               @RequestParam("tiempo") String nuevoTiempo,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("descripcion") String nuevaDescripcion){
        Estudio est = estudioServ.findEstudio(id);
        est.setTiempo(nuevoTiempo);
        est.setTitulo(nuevoTitulo);
        est.setDescripcion(nuevaDescripcion);
        est.setEditar(false);
        estudioServ.saveEstudio(est);
        return "El estudio ha sido editado";
    }
    
    
    
        // ------------ EXPERIENCIA ------------
    @Autowired
    private IExperienciaService experienciaServ;
    
    @GetMapping ("/experiencias")
    @ResponseBody
    public List<Experiencia> getExperiencias(){
        return experienciaServ.getExperiencias();
    }
    
    @PostMapping ("/experiencias")
    @ResponseBody
    public Experiencia createExperiencia(@RequestBody Experiencia exp){
       return experienciaServ.saveExperiencia(exp);
       
    }
    
     @DeleteMapping ("/experiencias/{id}")
    public List<Experiencia> deleteExperiencia (@PathVariable Long id){
        return experienciaServ.deleteExperiencia(id);
    }
 
    @PutMapping ("experiencias/{id}")
    public String editExperiencia (@PathVariable Long id,
                               @RequestParam("tiempo") String nuevoTiempo,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("descripcion") String nuevaDescripcion){
        Experiencia exp = experienciaServ.findExperiencia(id);
        exp.setTiempo(nuevoTiempo);
        exp.setTitulo(nuevoTitulo);
        exp.setDescripcion(nuevaDescripcion);
        exp.setEditar(false);
        experienciaServ.saveExperiencia(exp);
        return "La experiencia ha sido editada";
    }
      
    
    
        // ------------ PROYECTO ------------
    @Autowired
    private IProyectoService proyectoServ;
    
    @GetMapping ("/proyectos")
    @ResponseBody
    public List<Proyecto> getProyectos(){
        return proyectoServ.getProyectos();
    }
    
    @PostMapping ("/proyectos")
    public String createProyecto(@RequestBody Proyecto proy){
        proyectoServ.saveProyecto(proy);
        return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping ("/proyectos/{id}")
    public String deleteProyecto (@PathVariable Long id){
        proyectoServ.deleteProyecto(id);
        return "El proyecto fue eliminado correctamente";
    }
    
    @PutMapping ("proyectos/{id}")
    public String editProyecto (@PathVariable Long id,
                               @RequestParam("fecha") String nuevaFecha,
                               @RequestParam("titulo") String nuevoTitulo){
        Proyecto proy = proyectoServ.findProyecto(id);
        proy.setFecha(nuevaFecha);
        proy.setTitulo(nuevoTitulo);
        proyectoServ.saveProyecto(proy);
        return "El proyecto ha sido editado";
    }
    
    
    
        // ------------ LOGIN ------------
    @Autowired
    private IUsuarioService usuarioServ;
    
    @PostMapping("/login")
    public Usuario login (@RequestBody Usuario user){
        return usuarioServ.login(user.getUser(), user.getPassword());
    }
    

}
