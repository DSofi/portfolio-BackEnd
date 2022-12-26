
package com.probando.segunda.service;

import com.probando.segunda.model.Usuario;
import com.probando.segunda.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public Usuario saveUsuario(Usuario user) {
        return usuarioRepo.save(user);
    }

    @Override
    public List<Usuario> deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
        return usuarioRepo.findAll();
    }

    @Override
    public Long login(String user, String pass) {
    Usuario usuario = usuarioRepo.findByUserAndPassword(user, pass);
    if (usuario != null){
         return usuario.getId();
    }
         return 0L;
    }
    
    @Override
    public Usuario findUsuario(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }
    


    
}
