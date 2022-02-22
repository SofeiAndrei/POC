package userService.src.main.java.com.SofeiAndreiPOC.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userService.src.main.java.com.SofeiAndreiPOC.userService.entity.User;
import userService.src.main.java.com.SofeiAndreiPOC.userService.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/user")//path to get to this controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String id, Long userId){
        return userService.getUserById(userId);
    }
     */
    /*
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return Flux.
    }
    */


}
