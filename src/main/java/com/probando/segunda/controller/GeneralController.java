
package com.probando.segunda.controller;

import com.probando.segunda.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
    
    @Autowired
    private GeneralService generalServ;
    
    @DeleteMapping ("/delete-all")
    public void deleteAll (){
        generalServ.deleteAll();
    }
    
}
