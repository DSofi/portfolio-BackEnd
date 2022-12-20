
package com.probando.segunda.repository;

import com.probando.segunda.model.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository <Estudio, Long> {

}
