
package com.probando.segunda.controller;

import com.probando.segunda.model.Estudio;
import com.probando.segunda.service.IEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudioController {
    
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
    @ResponseBody
    public List<Estudio> deleteEstudio (@PathVariable Long id){
        return estudioServ.deleteEstudio(id);
    }
    
    @PutMapping ("estudios/{id}")
    @ResponseBody
    public Estudio editEstudio (@PathVariable Long id, @RequestBody Estudio estudio) {
    Estudio est = estudioServ.findEstudio(id);
        est.setTiempo(estudio.getTiempo());
        est.setTitulo(estudio.getTitulo());
        est.setDescripcion(estudio.getDescripcion());
        est.setOtrasNotas(estudio.getOtrasNotas());
        est.setEditar(false);
    return estudioServ.saveEstudio(est);
    }
    
    @GetMapping("estudios/{id}")
    @ResponseBody
    public Estudio findEstudio(@PathVariable Long id){
        return estudioServ.findEstudio(id);
    }
    
    @PutMapping("/estudios/order")
    @ResponseBody
    public List<Estudio> orderEstudios(@RequestBody List<Estudio> estudios){
        return estudioServ.orderEstudios(estudios);
    }
}
