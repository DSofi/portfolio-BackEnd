
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
        return experienciaRepo.findAllOrdered();
    }

    @Override
    public Experiencia saveExperiencia(Experiencia exp) {
        return experienciaRepo.save(exp);
    }
    
    @Override
    public Experiencia createExperiencia(Experiencia exp){
        Long count = experienciaRepo.count();
        exp.setOrden((int) (count+1));
        return experienciaRepo.save(exp);
    }

    @Override
    public List<Experiencia> deleteExperiencia(Long id) {
        experienciaRepo.deleteById(id);
        return experienciaRepo.findAllOrdered();
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        return experienciaRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Experiencia> orderExperiencias(List<Experiencia> experiencias) {
    for (int i = 0; i < experiencias.size(); i++) {
            Experiencia experiencia = experiencias.get(i);
            experiencia.setOrden(i);
            experienciaRepo.save(experiencia); 
            experienciaRepo.updateOrden(experiencia.getId(), i);
        }
       return experienciaRepo.findAllOrdered();
    }    
}
