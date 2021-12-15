
package com.usa.reto4.Services;

import com.usa.reto4.Modelos.Gadget;
import com.usa.reto4.Modelos.Order;
import com.usa.reto4.Repository.GadgetRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GadgetService {
    
    @Autowired
    private GadgetRepo repo;
    
    public List<Gadget> getAll() {
        return repo.getAll();
    }
    
    public Gadget save(Gadget gadget) { // Strings && Integer boolean
        if (gadget.getBrand() == null || gadget.getCategory()== null ||
        gadget.getName()== null || gadget.getDescription()== null ||
        gadget.getPrice()== 0.0 ||  
        gadget.getQuantity()== 0 || gadget.getPhotography()== null) {
            return gadget;
            
        } else {
            Optional<Gadget> userCrud = repo.findById(gadget.getId());
            if (userCrud.isEmpty()) {
                return repo.save(gadget);
                
            } return gadget;
            
        }
        
    }
    
    public Gadget getById(Integer id) {
        Optional<Gadget> gadget = repo.findById(id);
        if (gadget.isPresent()) {
         return gadget.get();
        }
          return new Gadget();
    }
    
    public Gadget update(Gadget gadget){
        if (gadget.getId() != null) {
            Optional<Gadget> gadgetUpdate = repo.findById(gadget.getId());
            if (gadgetUpdate.isPresent()) {
                if(gadget.getBrand() != null) {
                    gadgetUpdate.get().setBrand(gadget.getBrand());
                    
                } if(gadget.getCategory()!= null) {
                    gadgetUpdate.get().setCategory(gadget.getCategory());
                }
                if(gadget.getName()!=null){
                    gadgetUpdate.get().setName(gadget.getName());
                }
                
                if(gadget.getDescription()!=null){
                    gadgetUpdate.get().setDescription(gadget.getDescription());
                }
                if(gadget.getPrice()!=0.0){
                    gadgetUpdate.get().setPrice(gadget.getPrice());
                }
                if(true){
                    gadgetUpdate.get().setAvailability(gadget.getAvailability());
                }
                if(gadget.getQuantity()!=0){
                    gadgetUpdate.get().setQuantity(gadget.getQuantity());
                }
                if(gadget.getPhotography()!=null){
                    gadgetUpdate.get().setPhotography(gadget.getPhotography());
                }
                
                return repo.save(gadgetUpdate.get());
                
            } else { 
                return gadget;
            }
            
        } else {
            return gadget;
        }
        
    }
    
    
    public boolean delete(Integer id) {
        Optional<Gadget> gadget = repo.findById(id);
        if (gadget.isPresent()) {
            repo.deleteById(id);
            return true;
            
        } return false;
        
    }
    
    
    
}
