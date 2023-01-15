
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
        return tipoSkillRepo.findAllOrdered();
    }

    @Override
    public Tiposkill saveTipoSkill(Tiposkill tipoSkill) {
        return tipoSkillRepo.save(tipoSkill);
    }

    @Override
    public List<Tiposkill> deleteTipoSkill(Long id) {
        tipoSkillRepo.deleteById(id);
        return tipoSkillRepo.findAllOrdered();
    }

    @Override
    public Tiposkill findTipoSkill(Long id) {
        return tipoSkillRepo.findById(id).orElse(null);
    }    
    
    @Override
    public List<Tiposkill> orderSkills(List<Tiposkill> tiposSkills) {
    for (int i = 0; i < tiposSkills.size(); i++) {
            Tiposkill tiposkill = tiposSkills.get(i);
            tiposkill.setOrden(i);
            tipoSkillRepo.save(tiposkill); 
             tipoSkillRepo.updateOrden(tiposkill.getId(), i);
        }
       return tipoSkillRepo.findAllOrdered();
    }   
}
