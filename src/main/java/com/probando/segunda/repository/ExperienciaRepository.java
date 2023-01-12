
package com.probando.segunda.repository;

import com.probando.segunda.model.Experiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long> {
    
    @Transactional
    @Modifying
    @Query("UPDATE Experiencia e SET e.orden = :orden WHERE e.id = :id")    
    void updateOrden(@Param("id") Long id, @Param("orden") int orden);
    
    @Query("SELECT e FROM Experiencia e ORDER BY e.orden ASC")
    List<Experiencia> findAllOrdered();
    
}
