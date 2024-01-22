package com.cyrus.rest.webservices.restfulwebservices.socialmedia.controller;

import com.cyrus.rest.webservices.restfulwebservices.socialmedia.entity.User;
import com.cyrus.rest.webservices.restfulwebservices.socialmedia.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User retriveUser(@PathVariable int userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User userReqObj) {

        User savedUser = userService.save(userReqObj);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
