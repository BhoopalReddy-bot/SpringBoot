package org.vision.springrest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        ArrayList<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(u -> userList.add(u));
        return userList;
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUserUrl(User user, Long id){
        user.setId(id);
        userRepository.save(user);
    }

    public void updateUserPayload(User user){
        userRepository.save(user);
    }

    public List<User> getRequestedQuantityOfFirstUsers(Integer quantity){
        ArrayList<User> userList = new ArrayList<>();
        List<User> temp = getAllUsers();
        for(int i = 0; i < quantity; i++){
            userList.add(temp.get(i));
        }
        return userList;
    }
}
