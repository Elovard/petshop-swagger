package by.tms.controller;

import by.tms.model.Order;
import by.tms.model.OrderStatus;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(path = "/store/order")
public class StoreResource {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<Order> saveOrder (@Valid @RequestBody Order order){
        storeService.addOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<Order> getById (@PathVariable("id") long id){
        Order byId = storeService.getById(id);
        if (byId != null){
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Order> deleteById (@PathVariable("id") long id){
        Order byId = storeService.getById(id);
        if (byId != null){
            storeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//    @GetMapping(path = "/inventory")
//    public ResponseEntity<Map<OrderStatus, Long>> getInventory(){
//        Map<OrderStatus, Long> statusMap = storeService.getStatusMap();
//        return new ResponseEntity<>(statusMap, HttpStatus.OK);
//    }
}