
package com.probando.segunda.service;

import com.probando.segunda.model.Tiposkill;
import java.util.List;

public interface ITipoSkillService {
    public List<Tiposkill> getTipoSkills();
    public Tiposkill saveTipoSkill (Tiposkill tipoSkill);
    public List<Tiposkill> deleteTipoSkill (Long id);
    public Tiposkill findTipoSkill (Long id);    
}