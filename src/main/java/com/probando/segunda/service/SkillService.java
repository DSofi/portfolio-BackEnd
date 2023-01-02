
package com.probando.segunda.service;

import com.probando.segunda.model.Skill;
import com.probando.segunda.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    
    @Autowired
    private SkillRepository skillRepo;

    @Override
    public List<Skill> getSkills() {
        return skillRepo.findAll();
    }

    @Override
    public Skill saveSkill(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public List<Skill> deleteSkill(Long id) {
        skillRepo.deleteById(id);
        return skillRepo.findAll();
    }

    @Override
    public Skill findSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }
    
}
