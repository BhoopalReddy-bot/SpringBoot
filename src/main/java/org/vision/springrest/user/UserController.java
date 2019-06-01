package org.vision.springrest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value="/users", method=RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public void updateUserUrl(@RequestBody User user, @PathVariable Long id){
        userService.updateUserUrl(user, id);
    }

    @RequestMapping(value="/users}", method=RequestMethod.PUT)
    public void updateUserPayload(@RequestBody User user){
        userService.updateUserPayload(user);
    }

    @RequestMapping("/users={quantity}")
    public List<User> getRequestedQuantityOfFirstUsers(@PathVariable Integer quantity){
        return userService.getRequestedQuantityOfFirstUsers(quantity);
    }
}
