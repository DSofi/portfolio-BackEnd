
package com.probando.segunda.service;

import com.probando.segunda.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {
    
    public Usuario saveUsuario (Usuario user);
    public List<Usuario> deleteUsuario (Long id);
    public ResponseEntity<Object> login(String user, String pass);
    public Usuario findUsuario (Long id);
}
