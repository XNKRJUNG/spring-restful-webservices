package com.cyrus.rest.webservices.restfulwebservices.socialmedia.controller;

import com.cyrus.rest.webservices.restfulwebservices.socialmedia.entity.User;
import com.cyrus.rest.webservices.restfulwebservices.socialmedia.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User retriveUser(@PathVariable int userId){
        return userService.findUserById(userId);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User userReqObj){
        return userService.save(userReqObj);
    }
}
