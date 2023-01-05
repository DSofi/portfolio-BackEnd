
package com.probando.segunda.service;

import com.probando.segunda.model.Estudio;
import java.util.List;

public interface IEstudioService {
    public List<Estudio> getEstudios();
    public Estudio saveEstudio (Estudio est);
    public List<Estudio> deleteEstudio (Long id);
    public Estudio findEstudio (Long id);  
    public List<Estudio> orderEstudios(List<Estudio> estudios);
}
