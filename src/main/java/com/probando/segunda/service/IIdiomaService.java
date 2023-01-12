
package com.probando.segunda.service;

import com.probando.segunda.model.Idioma;
import java.util.List;

public interface IIdiomaService {
    public List<Idioma> getIdiomas();
    public Idioma saveIdioma (Idioma idioma);
    public Idioma createIdioma (Idioma idioma);
    public List<Idioma> deleteIdioma (Long id);
    public Idioma findIdioma (Long id);  
    public List<Idioma> orderIdiomas(List<Idioma> idiomas);
}
