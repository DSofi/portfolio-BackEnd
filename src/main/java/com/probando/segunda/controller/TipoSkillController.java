
package com.probando.segunda.controller;

import com.probando.segunda.model.Tiposkill;
import com.probando.segunda.service.TipoSkillService;
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
public class TipoSkillController {
    
    @Autowired 
    private TipoSkillService tipoSkillServ;
    
    @GetMapping("/tipo-skills")
    @ResponseBody
    public List<Tiposkill> getTipoSkills(){
        return tipoSkillServ.getTipoSkills();
    }
    
    @PostMapping("/tipo-skills")
    @ResponseBody
    public Tiposkill createTipoSkill(@RequestBody Tiposkill tipoSkill){
        return tipoSkillServ.saveTipoSkill(tipoSkill);
    }
    
    @DeleteMapping("/tipo-skills/{id}")
    @ResponseBody
    public List<Tiposkill> deleteTipoSkill(@PathVariable Long id){
        return tipoSkillServ.deleteTipoSkill(id);
    }
    
    @PutMapping("tipo-skills/{id}")
    public Tiposkill editTipoSkill(@PathVariable Long id, @RequestBody Tiposkill tipoSkill){
        Tiposkill tipoSk = tipoSkillServ.findTipoSkill(id);
        tipoSk.setNombre(tipoSkill.getNombre());
        return tipoSkillServ.saveTipoSkill(tipoSk);
    }    
    
    @PutMapping("/tipo-skills/order")
    @ResponseBody
    public List<Tiposkill> orderSkills(@RequestBody List<Tiposkill> tiposSkills){
        return tipoSkillServ.orderSkills(tiposSkills);
    }
}
