
package com.probando.segunda.service;

import com.probando.segunda.model.Tiposkill;
import com.probando.segunda.repository.TipoSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSkillService implements ITipoSkillService {
    
    @Autowired
    private TipoSkillRepository tipoSkillRepo;

    @Override
    public List<Tiposkill> getTipoSkills() {
        return tipoSkillRepo.findAll();
    }

    @Override
    public Tiposkill saveTipoSkill(Tiposkill tipoSkill) {
        return tipoSkillRepo.save(tipoSkill);
    }

    @Override
    public List<Tiposkill> deleteTipoSkill(Long id) {
        tipoSkillRepo.deleteById(id);
        return tipoSkillRepo.findAll();
    }

    @Override
    public Tiposkill findTipoSkill(Long id) {
        return tipoSkillRepo.findById(id).orElse(null);
    }
    
}
