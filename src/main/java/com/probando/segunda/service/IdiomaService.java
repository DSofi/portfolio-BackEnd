
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
        return idiomaRepo.findAllOrdered();
    }

    @Override
    public Idioma saveIdioma(Idioma idioma) {
        return idiomaRepo.save(idioma);
    }

    @Override
    public List<Idioma> deleteIdioma(Long id) {
        idiomaRepo.deleteById(id);
        return idiomaRepo.findAllOrdered();
    }

    @Override
    public Idioma findIdioma(Long id) {
        return idiomaRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Idioma> orderIdiomas(List<Idioma> idiomas) {
    for (int i = 0; i < idiomas.size(); i++) {
            Idioma idioma = idiomas.get(i);
            idioma.setOrden(i);
            idiomaRepo.save(idioma); 
            idiomaRepo.updateOrden(idioma.getId(), i);
        }
       return idiomaRepo.findAllOrdered();
    }
    
}
