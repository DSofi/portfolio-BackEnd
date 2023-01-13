
package com.probando.segunda.service;

import com.probando.segunda.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public Proyecto saveProyecto (Proyecto proy);
    public Proyecto createProyecto(Proyecto proy);
    public List<Proyecto> deleteProyecto (Long id);
    public Proyecto findProyecto (Long id);
    public List<Proyecto> orderProyectos(List<Proyecto> proyectos);
}
