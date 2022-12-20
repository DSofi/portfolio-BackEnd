
package com.probando.segunda.service;

import com.probando.segunda.model.Persona;
import com.probando.segunda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        if (pers != null){
            if (!"".equals(pers.getNombre()) && !"".equals(pers.getSobreMi())){
            persoRepo.save(pers);}
        }}
        

    

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);

    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
      
    }
}
