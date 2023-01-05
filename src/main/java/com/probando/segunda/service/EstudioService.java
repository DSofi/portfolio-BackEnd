
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
        return estudioRepo.findAllOrdered();
    }

    @Override
    public Estudio saveEstudio(Estudio est) {
        return estudioRepo.save(est);
    }

    @Override
    public List<Estudio> deleteEstudio(Long id) {
        estudioRepo.deleteById(id);
        return estudioRepo.findAllOrdered();
    }

    @Override
    public Estudio findEstudio(Long id) {
        return estudioRepo.findById(id).orElse(null);
    }
    @Override
    public List<Estudio> orderEstudios(List<Estudio> estudios) {
    for (int i = 0; i < estudios.size(); i++) {
            Estudio estudio = estudios.get(i);
            estudio.setOrden(i);
            estudioRepo.save(estudio); 
            estudioRepo.updateOrden(estudio.getId(), i);
        }
       return estudioRepo.findAllOrdered();
    }    
}
