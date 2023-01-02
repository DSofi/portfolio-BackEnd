
package com.probando.segunda.service;

import com.probando.segunda.model.Skill;
import java.util.List;

public interface ISkillService {
    public List<Skill> getSkills();
    public Skill saveSkill(Skill skill);
    public List<Skill> deleteSkill (Long id);
    public Skill findSkill (Long id);
}
