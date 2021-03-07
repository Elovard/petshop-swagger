package by.tms.service;

import by.tms.model.Order;
import by.tms.storage.InMemoryOrderStorage;
import by.tms.storage.IsNotFoundException;
import by.tms.storage.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;   // через интерсептор разрешить доступ к другим частям сайта (под замком которые)
import java.util.List;
import java.util.Map;
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
