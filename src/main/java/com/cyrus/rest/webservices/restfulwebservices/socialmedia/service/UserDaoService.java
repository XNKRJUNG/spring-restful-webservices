package com.cyrus.rest.webservices.restfulwebservices.socialmedia.service;

import com.cyrus.rest.webservices.restfulwebservices.socialmedia.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Cyrus", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Tan", LocalDate.now().minusYears(23)));
        users.add(new User(++usersCount, "Mukesh", LocalDate.now().minusYears(20)));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .get();
    }

    public User save(User userReqObj) {
        userReqObj.setId(++usersCount);
        users.add(userReqObj);
        return userReqObj;
//        return findUserById(userReqObj.getId());

//        return users.stream()
//                .filter(user -> user.getId().equals(userReqObj.getId()))
//                .findFirst()
//                .get();
    }
}
