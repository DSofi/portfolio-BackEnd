
package com.probando.segunda.controller;

import com.probando.segunda.model.Usuario;
import com.probando.segunda.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class UsuarioController {
    
        @Autowired
    private IUsuarioService usuarioServ;
    
    @PostMapping("/iniciar-sesion")
    public Long login (@RequestBody Usuario user){
        return usuarioServ.login(user.getUser(), user.getPassword());
    }
    
    @PostMapping("/usuarios")
    @ResponseBody
    public Usuario createUsuario(@RequestBody Usuario user){
        return usuarioServ.saveUsuario(user);
    }    
    
      @PutMapping ("usuarios/{id}")
    public Usuario editUsuario (@PathVariable Long id,
                               @RequestBody Usuario usuario){
        Usuario user = usuarioServ.findUsuario(id);
        user.setUser(usuario.getUser());
        user.setPassword(usuario.getPassword());
        user.setEmail(usuario.getEmail());
        user.setPersona(usuario.getPersona());
        return usuarioServ.saveUsuario(user);
    }
    
}
