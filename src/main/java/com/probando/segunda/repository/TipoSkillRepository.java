
package com.probando.segunda.repository;

import com.probando.segunda.model.Tiposkill;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSkillRepository extends JpaRepository<Tiposkill, Long>{
    
    @Transactional
    @Modifying
    @Query("UPDATE Tiposkill t SET t.orden = :orden WHERE t.id = :id")    
    void updateOrden(@Param("id") Long id, @Param("orden") int orden);
    
    @Query("SELECT t FROM Tiposkill t ORDER BY t.orden ASC")
    List<Tiposkill> findAllOrdered();
    
}
