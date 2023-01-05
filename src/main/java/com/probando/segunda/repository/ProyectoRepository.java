
package com.probando.segunda.repository;

import com.probando.segunda.model.Proyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long>{
    
     @Modifying
    @Query("UPDATE Proyecto p SET p.orden = :orden WHERE p.id = :id")
    @Transactional
    void updateOrden(@Param("id") Long id, @Param("orden") int orden);
    
    @Query("SELECT p FROM Proyecto p ORDER BY p.orden ASC")
    List<Proyecto> findAllOrdered();
    
}
