package by.tms.service;

import by.tms.model.User;
import by.tms.storage.InMemoryUserStorage;
import by.tms.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserById(long id){
       return userRepository.getOne(id);
    }

    public void removeUserById(long id){
      userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByName(String name){
        return userRepository.findUserByFirstName(name);
    }


//    public boolean save(User user){
//        return inMemoryUserStorage.add(user);
//    }
//
//    public void addAllList(List<User> users){
//        for (User user : users) {
//            inMemoryUserStorage.add(user);
//        }
//    }
//
//    public void addAllArray(User [] users){
//        for (User user : users) {
//            inMemoryUserStorage.add(user);
//        }
//    }
//
//    public User getByUserName(String userName){
//        return inMemoryUserStorage.getByUserName(userName);
//    }
//
//    public boolean updateByUserName(User user, String userName){
//        return inMemoryUserStorage.updateByUserName(user, userName);
//    }
//
//    public boolean deleteByUserName(String userName){
//        return inMemoryUserStorage.deleteByUserName(userName);
//    }
}
