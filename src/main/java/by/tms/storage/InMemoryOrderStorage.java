package by.tms.storage;

import by.tms.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrderStorage {
    private static long gen = 0;
    private List<Order>orders = new ArrayList<>();

    public boolean add(Order order){
        order.setId(gen++);
        return orders.add(order);
    }

    public Order getById(long id){
        for (Order order : orders) {
            if (order.getId()==id) {
                return order;
            }
        }
        return null;
    }

    public boolean deleteById(long id){
        for (Order order : orders) {
            if (order.getId()==id) {
                orders.remove(order);
                return true;
            }
        }
        return false;
    }

    public List<Order> getOrders(){
        return new ArrayList<>(orders);
    }
}
