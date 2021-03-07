package by.tms.controller;

import by.tms.model.Token;
import by.tms.model.User;
import by.tms.model.UserDTO;
import by.tms.service.UserService;
import by.tms.storage.InMemoryUserStorage;
import by.tms.storage.TokenStorage;
import by.tms.storage.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStorage tokenStorage;

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

//    @PostMapping(path = "/auth")
//    public ResponseEntity<String> auth(@RequestBody User user) {
//        if (userService.isExist(user.getUserName())) {
//            UUID uuid = UUID.randomUUID();
//            String s = uuid.toString();
//            tokenStorage.save(s);
//            return new ResponseEntity<>(s, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(@Valid @RequestBody UserDTO userDTO){
        User user = new User();
        String userName = userDTO.getUserName();
        String password = userDTO.getPassword();
        user.setUserName(userName);
        user.setPassword(password);
        User byLogin = userService.getUserByName(userName);
        Token token = userService.auth(byLogin);
        return new ResponseEntity<>(token.getKey(), HttpStatus.OK);
    }

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

