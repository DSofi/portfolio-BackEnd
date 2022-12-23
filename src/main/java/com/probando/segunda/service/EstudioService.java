
package com.probando.segunda.service;

import com.probando.segunda.model.Estudio;
import com.probando.segunda.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService {

    @Autowired
    private EstudioRepository estudioRepo;
    
    @Override
    public List<Estudio> getEstudios() {
        return estudioRepo.findAll();
    }

    @Override
    public Estudio saveEstudio(Estudio est) {
        System.out.println("Guardando desde el servicio: " + est);
        return estudioRepo.save(est);
        
    }

    @Override
    public List<Estudio> deleteEstudio(Long id) {
        estudioRepo.deleteById(id);
        return estudioRepo.findAll();
    }

    @Override
    public Estudio findEstudio(Long id) {
        return estudioRepo.findById(id).orElse(null);
    }
    
}
