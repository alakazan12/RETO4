


package com.usa.reto4.web;

import com.usa.reto4.Modelos.Gadget;
import com.usa.reto4.Modelos.Order;
import com.usa.reto4.Services.GadgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/gadget")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GadgetWeb {
    
    @Autowired
    private GadgetService service;
    
    // - - - - - - - < GET > - - - - - - - 
    
    @GetMapping("/all")
    public List<Gadget> getAll() {
        return service.getAll();
    }
    
    // < GET - GADGET BY ID >
    @GetMapping("/{id}")
    public Gadget getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }
    
    // - - - - - - - < POST > - - - - - - - 
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    //HttpStatus.CREATED
    public Gadget save(@RequestBody Gadget gadget) {
        return service.save(gadget);
    }
    
    // - - - - - - - < PUT > - - - - - - - 
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget){
        return service.update(gadget);
    }
    
    // - - - - - - - < DELETE > - - - - - - - 
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    
    
    
}
