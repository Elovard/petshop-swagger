package by.tms.controller;

import by.tms.model.Order;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(path = "/store")
public class StoreResource {

    @Autowired
    private StoreService storeService;

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder (@Valid @RequestBody Order order){
        storeService.addOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getById (@PathVariable("id") long id){
        Order byId = storeService.getById(id);
        if (byId != null){
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Order> deleteById (@PathVariable("id") long id){
        Order byId = storeService.getById(id);
        if (byId != null){
            storeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//
//    @GetMapping("/inventory")
//    public ResponseEntity<Map<String, Integer>> getMapStatus() {
//        Map<String, Integer> mapStatus = storeService.getMapStatus();
//        return new ResponseEntity<>(mapStatus, HttpStatus.OK);
//    }
}