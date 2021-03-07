package by.tms.service;

import by.tms.model.Order;
import by.tms.exception.IsNotFoundException;
import by.tms.storage.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private OrderRepository orderRepository;

    public void deleteById(long id){
        orderRepository.deleteById(id);
    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public Order getById(long id){
        Optional<Order> byId = orderRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new IsNotFoundException("This order doesn't exist!");
    }



}
