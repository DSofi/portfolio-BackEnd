
package com.probando.segunda.repository;

import com.probando.segunda.model.Skill;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
    @Transactional
    @Modifying
    @Query("UPDATE Skill s SET s.orden = :orden WHERE s.id = :id")
    void updateOrden(@Param("id") Long id, @Param("orden") int orden);
    
    @Query("SELECT s FROM Skill s ORDER BY s.orden ASC")
    List<Skill> findAllOrdered();
    
}
