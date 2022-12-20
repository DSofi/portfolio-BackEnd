
package com.probando.segunda.service;

import com.probando.segunda.model.Usuario;
import com.probando.segunda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public void saveUsuario(Usuario user) {
        usuarioRepo.save(user);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario login(String user, String pass) {
        return usuarioRepo.findByUserAndPassword(user, pass);
    }
    
}
