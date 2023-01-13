
package com.probando.segunda.controller;

import com.probando.segunda.model.Skill;
import com.probando.segunda.service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    
    @Autowired
    private SkillService skillServ;
    
    
    @GetMapping("/skills")
    @ResponseBody
    public List<Skill> getSkills(){
        return skillServ.getSkills();
    }
    
    @PostMapping("/skills")
    @ResponseBody
    public Skill createSkill(@RequestBody Skill skill){             
        return skillServ.createSkill(skill);
    }
    
    @DeleteMapping("/skills/{id}")
    @ResponseBody
    public List<Skill> deleteSkill(@PathVariable Long id){
        return skillServ.deleteSkill(id);
    }
    
    @PutMapping("/skills/{id}")
    public Skill editSkill(@PathVariable Long id, @RequestBody Skill skill){
        Skill sk= skillServ.findSkill(id);
        sk.setNombre(skill.getNombre());
        sk.setImagen(skill.getImagen());
        sk.setTiposkill(skill.getTiposkill());       
        return skillServ.saveSkill(sk);
    }    
    
    @PutMapping("/skills/order")
    @ResponseBody
    public List<Skill> orderSkills(@RequestBody List<Skill> skills){
        return skillServ.orderSkills(skills);
    }
}
