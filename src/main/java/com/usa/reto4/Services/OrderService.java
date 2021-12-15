
package com.usa.reto4.Services;

import com.usa.reto4.Modelos.Order;
import com.usa.reto4.Repository.OrderRepo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    // - - - - - - - < ATRIBUTOS > - - - - - - - 
    
    @Autowired
    private OrderRepo repo;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    // - - - - - - - < GET > - - - - - - - 
    
    
    
    // < GET - ALL ORDERS >
    public List<Order> getAll() {
        return repo.getAll();
    }
    
    // < GET - ORDER BY ID >
    public Order getById(Integer id) {
        Optional<Order> order = repo.findById(id);
        
        if (order.isPresent()) {
            return order.get();
            
        } return new Order();
    }
    
    // < GET - ORDER BY USER ID >
    public List<Order> getUsersById(Integer id) {
        return repo.getUserById(id);
    }
    
    // < GET - ORDERS BY USER ZONE >
    public List<Order> getOrdersByUserZone(String zone) {
        return repo.getOrdersByUserZone(zone);
    }
    
    // < GET - ORDER BY STATUS >
    public List<Order> getOrderByStatus(String status) {
        return repo.getOrderByStatus(status);
    }
    
    // < GET - ORDER BY STATUS AND BY USER ID >
    public List<Order> getByStatusAndByUserId(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
    }
    
    
    // < GET - ORDER BY DATE AND BY USER ID >
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
        
    }
    
    
    
    // - - - - - - - < POST > - - - - - - - 
    public Order save(Order order) { // Strings && Integer boolean
        if (order.getRegisterDay() == null || order.getStatus()== null ||
        order.getSalesMan()== null || order.getProducts()== null ||
        order.getQuantities()== null) {
        return order;
            
        } else {
            Optional<Order> orderCrud = repo.findById(order.getId());
            if (orderCrud.isEmpty()) {
                return repo.save(order);
                
            } return order;
            
        }
        
    }
    
    // - - - - - - - < PUT > - - - - - - - 
    public Order update(Order order){
        if (order.getId() != null) {
            Optional<Order> orderUpdate = repo.findById(order.getId());
            if (orderUpdate.isPresent()) {
                if(order.getRegisterDay() != null) {
                    orderUpdate.get().setRegisterDay(order.getRegisterDay());
                    
                } if(order.getStatus()!= null) {
                    orderUpdate.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan()!=null){
                    orderUpdate.get().setSalesMan(order.getSalesMan());
                }
                
                if(order.getProducts()!=null){
                    orderUpdate.get().setProducts(order.getProducts());
                }
                if(order.getQuantities()!=null){
                    orderUpdate.get().setQuantities(order.getQuantities());
                }
                
                
                return repo.save(orderUpdate.get());
                
            } else { 
                return order;
            }
            
        } else {
            return order;
        }
        
    }
    
    // - - - - - - - < DELETE > - - - - - - - 
    public boolean delete(Integer id) {
        Optional<Order> order = repo.findById(id);
        if (order.isPresent()) {
            repo.deleteById(id);
            return true;
            
        } return false;
        
    }
    
    
    
}
