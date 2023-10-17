package com.springJwt.controller;

import com.springJwt.models.User;
import com.springJwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    // http://localhost:8081/home/user
//    private Logger logger=new Logger() {
//    }

    @Autowired
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser()
    {
        return "Working";
    }


    @GetMapping ("/user-role")
    public  String hasUserRole()
    {
        return "You have User Role";
    }


}
