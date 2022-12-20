
package com.probando.segunda.service;

import com.probando.segunda.model.Experiencia;
import com.probando.segunda.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository experienciaRepo;

    @Override
    public List<Experiencia> getExperiencias() {
        return experienciaRepo.findAll();
    }

    @Override
    public Experiencia saveExperiencia(Experiencia exp) {
        return experienciaRepo.save(exp);
    }

    @Override
    public List<Experiencia> deleteExperiencia(Long id) {
        experienciaRepo.deleteById(id);
        return experienciaRepo.findAll();
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        return experienciaRepo.findById(id).orElse(null);
    }
    
}
