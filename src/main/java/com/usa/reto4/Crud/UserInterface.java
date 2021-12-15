
package com.usa.reto4.Crud;

import com.usa.reto4.Modelos.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface UserInterface extends MongoRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);

    
}
