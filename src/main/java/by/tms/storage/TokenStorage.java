package by.tms.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TokenStorage {

    @Autowired
    private UserRepository userRepository;

    List<String> userList = new ArrayList<>();

    public void save (String s){
        userList.add(s);
    }

    public boolean valid(String s){
        return userList.contains(s);
    }

}
