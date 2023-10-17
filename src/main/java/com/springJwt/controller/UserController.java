package com.springJwt.controller;

import com.springJwt.models.User;
import com.springJwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @PostMapping("/register-user")
    public User registerUser(@RequestBody User user)
    {
        User user1=userService.createUser(user);
        return user1;
    }

    @GetMapping("/user-by-email")
    public User getUserByEmail(@RequestParam String username )
    {
       User user=userService.getUserByUsername(username);
        if(user!=null)
        {
            return user;
        }
        else {
            throw new UsernameNotFoundException("User name is not Exist");
        }

    }



}
