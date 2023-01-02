
package com.probando.segunda.service;

import com.probando.segunda.model.Idioma;
import java.util.List;
import org.springframework.stereotype.Service;

public interface IIdiomaService {
    public List<Idioma> getIdiomas();
    public Idioma saveIdioma (Idioma idioma);
    public List<Idioma> deleteIdioma (Long id);
    public Idioma findIdioma (Long id);  
}
