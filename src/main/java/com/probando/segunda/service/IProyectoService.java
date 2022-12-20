
package com.probando.segunda.service;

import com.probando.segunda.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void saveProyecto (Proyecto proy);
    public void deleteProyecto (Long id);
    public Proyecto findProyecto (Long id);
}
