


package com.usa.reto4.web;

import com.usa.reto4.Modelos.User;
import com.usa.reto4.Services.UserService;
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
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserWeb {
    
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public User getuserID(@PathVariable("id") Integer id) {
        return service.getUsuario(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    //HttpStatus.CREATED
    public User save(@RequestBody User user) {
        return service.save(user);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean getEmail(@PathVariable("email") String email) {
        return service.verficarEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User getUser(@PathVariable("email") String email,@PathVariable("password") String password) {
        return service.verificaUsuario(email, password);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.deleteUser(id);
    }
    
    
    
}
