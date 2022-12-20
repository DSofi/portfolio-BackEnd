
package com.probando.segunda.service;

import com.probando.segunda.model.Proyecto;
import com.probando.segunda.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepo;

    @Override
    public List<Proyecto> getProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public void saveProyecto(Proyecto proy) {
        proyectoRepo.save(proy);
    }

    @Override
    public void deleteProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }
    
}
