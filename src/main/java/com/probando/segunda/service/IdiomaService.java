
package com.probando.segunda.service;

import com.probando.segunda.model.Idioma;
import com.probando.segunda.repository.IdiomaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService implements IIdiomaService {
    
    @Autowired
    private IdiomaRepository idiomaRepo;

    @Override
    public List<Idioma> getIdiomas() {
        return idiomaRepo.findAll();
    }

    @Override
    public Idioma saveIdioma(Idioma idioma) {
        return idiomaRepo.save(idioma);
    }

    @Override
    public List<Idioma> deleteIdioma(Long id) {
        idiomaRepo.deleteById(id);
        return idiomaRepo.findAll();
    }

    @Override
    public Idioma findIdioma(Long id) {
        return idiomaRepo.findById(id).orElse(null);
    }
    
}
