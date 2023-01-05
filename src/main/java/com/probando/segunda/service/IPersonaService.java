
package com.probando.segunda.service;

import com.probando.segunda.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    public Persona savePersona (Persona pers);
    public List<Persona> deletePersona (Long id);
    public Persona findPersona (Long id);    
}

