
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
    public Proyecto saveProyecto(Proyecto proy) {
        return proyectoRepo.save(proy);
    }

    @Override
    public List<Proyecto> deleteProyecto(Long id) {
        proyectoRepo.deleteById(id);
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }
}
