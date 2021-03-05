package by.tms.controller;

import by.tms.model.User;
import by.tms.service.UserService;
import by.tms.storage.InMemoryUserStorage;
import by.tms.storage.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")  // if exist
    public ResponseEntity<User> deleteByUserName(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @GetMapping("{userName}")
    public ResponseEntity<User> getByUserName(@PathVariable("userName") String userName){
        User byLogin = userService.getUserByName(userName);
        if (byLogin != null) {
            return new ResponseEntity<>(byLogin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

