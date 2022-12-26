
package com.probando.segunda.security;

import com.probando.segunda.model.Usuario;
import com.probando.segunda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findOneByUser(user).orElseThrow(() -> new UsernameNotFoundException("El usuario " + user + " no existe."));
        return new UserDetailsImpl(usuario);
    }
}
