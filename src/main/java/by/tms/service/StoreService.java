package by.tms.service;

import by.tms.model.Order;
import by.tms.storage.InMemoryOrderStorage;
import by.tms.storage.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return orderRepository.getOne(id);
    }


//    @Autowired
//    public InMemoryOrderStorage inMemoryOrderStorage;
//
//    public boolean save(Order order){
//        return inMemoryOrderStorage.add(order);
//    }
//
//    public boolean deleteById(long id){
//        return inMemoryOrderStorage.deleteById(id);
//    }
//
//    public Order getById(long id){
//        return inMemoryOrderStorage.getById(id);
//    }
//
//    public Map<String, Integer> getMapStatus(){
//        List<Order> orders = inMemoryOrderStorage.getOrders();
//        Map<String, Integer> mapStatus = new HashMap<>();
//        int numberOfplaced = 0;
//        int numberOfapproved = 0;
//        int numberOfdelivered = 0;
//        for (Order order : orders) {
//            if(order.getStatus().equals("PLACED")){   // .name().
//                numberOfplaced++;
//            } else if(order.getStatus().equals("APPROVED")){
//                numberOfapproved++;
//            }else {
//                numberOfdelivered++;
//            }
//        }
//        mapStatus.put("PLACED", numberOfplaced);
//        mapStatus.put("APPROVED", numberOfapproved);
//        mapStatus.put("DELIVERED", numberOfdelivered);
//        return mapStatus;
//    }
}
