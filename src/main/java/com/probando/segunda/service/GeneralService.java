
package com.probando.segunda.service;

import com.probando.segunda.model.Estudio;
import com.probando.segunda.model.Experiencia;
import com.probando.segunda.model.Idioma;
import com.probando.segunda.repository.EstudioRepository;
import com.probando.segunda.repository.ExperienciaRepository;
import com.probando.segunda.repository.IdiomaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
    
     @Autowired
    private EstudioRepository estudioRepo;     
    @Autowired
    private ExperienciaRepository experienciaRepo;
    @Autowired
    private IdiomaRepository idiomaRepo;
    
    public void deleteAll(){
        deleteAllExp();
        deleteAllEst();
        deleteAllIdio();
    }
    
    public List<Experiencia> deleteAllExp(){
        experienciaRepo.deleteAll();
        return experienciaRepo.findAllOrdered();
    }
    
    public List<Estudio> deleteAllEst(){
        estudioRepo.deleteAll();
        return estudioRepo.findAllOrdered();
    }
    
    public List<Idioma> deleteAllIdio(){
        idiomaRepo.deleteAll();
        return idiomaRepo.findAllOrdered();
    }
}
