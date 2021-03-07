package by.tms.service;

import by.tms.model.Token;
import by.tms.model.User;
import by.tms.model.UserRoleEnum;
import by.tms.exception.UserAlreadyExistsException;
import by.tms.exception.UserNotFoundException;
import by.tms.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public boolean isExist(String userName){
        if(userRepository.existsByUserName(userName)){
            return true;
        } else {
            return false;
        }
    }

    public User addUser(User user){
        if (!userRepository.existsByUserName(user.getUserName())) {
            user.setRole(UserRoleEnum.USER);
            return userRepository.save(user);
        }
        throw new UserAlreadyExistsException("This user already exists");
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

    public User getUserByName(String userName){
        return userRepository.findUserByFirstName(userName);
    }

    public Token auth(User user){
        User byUserName = userRepository.findUserByFirstName(user.getUserName());
        if (user.equals(byUserName)) {
            long id = byUserName.getId();
            Token token = tokenService.getKey(id);
            return token;
        }
        throw new UserNotFoundException("Incorrect login or password!");
    }

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
