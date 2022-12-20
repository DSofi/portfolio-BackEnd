
package com.probando.segunda.repository;

import com.probando.segunda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository <Usuario, Long> {
         public Usuario findByUserAndPassword(String user, String password);

}
