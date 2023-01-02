
package com.probando.segunda.repository;

import com.probando.segunda.model.Tiposkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSkillRepository extends JpaRepository<Tiposkill, Long>{
    
}
