
package com.probando.segunda.repository;

import com.probando.segunda.model.Idioma;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepository  extends JpaRepository <Idioma, Long>{
    
    @Transactional
    @Modifying
    @Query("UPDATE Idioma i SET i.orden = :orden WHERE i.id = :id")
    void updateOrden(@Param("id") Long id, @Param("orden") int orden);
    
    @Query("SELECT i FROM Idioma i ORDER BY i.orden ASC")
    List<Idioma> findAllOrdered();
    
}
