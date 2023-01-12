
package com.probando.segunda.service;

import com.probando.segunda.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> getExperiencias();
    public Experiencia saveExperiencia (Experiencia exp);
    public Experiencia createExperiencia (Experiencia exp);
    public List<Experiencia> deleteExperiencia (Long id);
    public Experiencia findExperiencia (Long id); 
    public List<Experiencia> orderExperiencias(List<Experiencia> experiencias);
}
