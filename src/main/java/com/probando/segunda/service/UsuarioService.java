
package com.probando.segunda.service;

import com.probando.segunda.model.Usuario;
import com.probando.segunda.repository.UsuarioRepository;
import com.probando.segunda.security.TokenUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<Object> login(String user, String pass) {
  Usuario usuario = usuarioRepo.findByUserAndPassword(user, pass);
  if (usuario != null) {
    String token = TokenUtils.createToken(user);
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return ResponseEntity.ok().body(response);
  } else {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error: usuario o contraseña incorrectos");
  }
}
    
    @Override
    public Usuario findUsuario(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }    
}
