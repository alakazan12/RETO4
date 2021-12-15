
package com.usa.reto4.Services;

import com.usa.reto4.Modelos.User;
import com.usa.reto4.Repository.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepo repo;
    
    public List<User> getAll() {
        return repo.getAll();
    }
    
    public User getUsuario(Integer id){
        Optional<User> user = repo.findById(id);
        if (user.isPresent()){
            return user.get(); // {id ... , dasasdas}
            
        }return new User(); // {id: null, }
    }
    
    public boolean verficarEmail(String email) {
        return repo.findByEmail(email).isPresent();        
    }
    
    public User verificaUsuario(String email,String password){
        Optional<User> usuario = repo.findByEmailAndPassword(email, password);
        if(usuario.isPresent()){
            return usuario.get();
        }
        return new User();
    }
    
    public User save(User user) {
        if (user.getIdentification() == null || user.getName()== null ||
        user.getAddress()== null || user.getCellPhone()== null ||
        user.getEmail()== null || user.getPassword()== null || 
        user.getZone()== null || user.getType()== null) {
            return user;
            
        } else {
            Optional<User> userCrud = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userCrud.isEmpty()) {
                return repo.save(user);
                
            } return user;
            
        }
        
    }
    
    public User update(User user){
        if (user.getId() != null) {
            Optional<User> userUpdate = repo.findById(user.getId());
            if (userUpdate.isPresent()) {
                if(user.getIdentification() != null) {
                    userUpdate.get().setIdentification(user.getIdentification());
                    
                } if(user.getName()!= null) {
                    userUpdate.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userUpdate.get().setAddress(user.getAddress());
                }
                
                if(user.getCellPhone()!=null){
                    userUpdate.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userUpdate.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userUpdate.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userUpdate.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userUpdate.get().setType(user.getType());
                }
                
                return repo.save(userUpdate.get());
                
            } else { 
                return user;
            }
            
        } else {
            return user;
        }
        
    }
    
    
    public boolean deleteUser(Integer id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            repo.deleteById(id);
            return true;
            
        } return false;
        
    }
    
    
    
}
