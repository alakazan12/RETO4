
package com.usa.reto4.Crud;

import com.usa.reto4.Modelos.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface GadgetInterface extends MongoRepository<Gadget, Integer> {
    
    
    
}
