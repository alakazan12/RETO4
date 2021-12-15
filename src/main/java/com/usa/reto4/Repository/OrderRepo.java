

package com.usa.reto4.Repository;

import com.usa.reto4.Crud.OrderInterface;
import com.usa.reto4.Modelos.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class OrderRepo {
    
    @Autowired
    private OrderInterface inter;
    
    public List<Order> getAll() {
        return inter.findAll();
    }
    
    public Optional<Order> findById(Integer id) {
        return inter.findById(id);
    }
    
    // Buscar por zona de usuario
    public List<Order> getOrdersByUserZone(String zone) {
        return inter.findUserByZone(zone);
    }
    
    // Buscar por estado de orden
    public List<Order> getOrderByStatus(String status) {
        return inter.findByStatus(status);
    }
    
    // Buscar por id de usuario
    public List<Order> getUserById(Integer id) { 
        return inter.findUserById(id);
    }
    
    public Order save(Order order) {
        return inter.save(order);
    }
    
    public void deleteById(Integer id) {
        inter.deleteById(id);
    }
    
    
}
