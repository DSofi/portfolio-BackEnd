
package com.probando.segunda.service;

import com.probando.segunda.model.Usuario;

public interface IUsuarioService {
    
    public void saveUsuario (Usuario pers);
    public void deleteUsuario (Long id);
    public Usuario login(String user, String pass);
}
