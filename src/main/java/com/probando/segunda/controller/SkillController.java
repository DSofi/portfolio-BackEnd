
package com.probando.segunda.controller;

import com.probando.segunda.model.Skill;
import com.probando.segunda.service.SkillService;
import com.probando.segunda.service.UploadImageService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class SkillController {
    
    @Autowired
    private SkillService skillServ;
    
    @Autowired
    private UploadImageService imageServ;
    
    @GetMapping("/skills")
    @ResponseBody
    public List<Skill> getSkills(){
        return skillServ.getSkills();
    }
    
    @PostMapping("/skills")
    @ResponseBody
    public Skill createSkill(@RequestBody Skill skill, @RequestParam(value = "file", required = false) MultipartFile imagen) throws IOException{
        
         if (imagen != null && !imagen.isEmpty()) {
            String filename = imageServ.copy(imagen);
            skill.setImagen(filename);
          }
        /*if (!imagen.isEmpty()){
            Path dirImages = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = dirImages.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                skill.setImagen(imagen.getOriginalFilename());
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/
            
            
        
        return skillServ.saveSkill(skill);
    }
    
    @DeleteMapping("/skills/{id}")
    @ResponseBody
    public List<Skill> deleteSkill(@PathVariable Long id){
        return skillServ.deleteSkill(id);
    }
    
    @PutMapping("/skills/{id}")
    public Skill editSkill(@PathVariable Long id, @RequestBody Skill skill, @RequestParam("file") MultipartFile imagen) throws IOException{
        Skill sk= skillServ.findSkill(id);
        sk.setNombre(skill.getNombre());
        /*sk.setImagen(skill.getImagen());*/
        sk.setTiposkill(skill.getTiposkill());
        
        if (!imagen.isEmpty()) {
            // Borra la imagen anterior si existe
            if (sk.getImagen() != null) {
              imageServ.delete(sk.getImagen());
            }
            // Carga la nueva imagen
                String filename = imageServ.copy(imagen);
                sk.setImagen(filename);
            }
        return skillServ.saveSkill(sk);
    }    
}
