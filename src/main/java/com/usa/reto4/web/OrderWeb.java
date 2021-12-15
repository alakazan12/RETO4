


package com.usa.reto4.web;

import com.usa.reto4.Modelos.Order;
import com.usa.reto4.Services.OrderService;
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
@RequestMapping("/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderWeb {
    
    @Autowired
    private OrderService service;
    
    // - - - - - - - < GET > - - - - - - - 
    
    @GetMapping("/all")
    public List<Order> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }
    
    @GetMapping("/zona/{zona}")
    public List<Order> getByZone(@PathVariable("zona") String zone) {
        return service.getOrdersByUserZone(zone);
    }
    
    // < GET - ORDERS BY USER ID >
    @GetMapping("/salesman/{id}")
    public List<Order> getUsersById(@PathVariable("id") Integer id) {
        return service.getUsersById(id);
    }
    
    // < GET - ORDERS BY STATUS AND BY USER ID >
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusAndByUserId(@PathVariable("status") String status,@PathVariable("id") Integer id) {
        return service.getByStatusAndByUserId(status, id);
    }
    
    // < GET - ORDERS BY DATE AND BY USER ID >
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByDateAndByUserId(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return service.ordersSalesManByDate(date, id);
    }
    
    
    // - - - - - - - < POST > - - - - - - - 
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    //HttpStatus.CREATED
    public Order save(@RequestBody Order order) {
        return service.save(order);
    }
    
    // - - - - - - - < PUT > - - - - - - - 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }
    
    // - - - - - - - < DELETE > - - - - - - - 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    
    
    
    
}
