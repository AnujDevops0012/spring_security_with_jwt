package com.springJwt.service;

import com.springJwt.Exceptions.EmailAlreadyExistsException;
import com.springJwt.models.User;
import com.springJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public  User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Boolean isEmailExist=userRepository.existsByEmail(user.getEmail());
        if(isEmailExist)
        {
            throw new EmailAlreadyExistsException(user.getEmail());
//            throw new BadCredentialsException("User already exist");
        }
        User user1=userRepository.save(user);
        return user1;
    }
//    @ExceptionHandler(BadCredentialsException.class)
//    public String exceptionHandler() {
//        return "User Already Exist ";
//    }
    public User getUserByUsername(String email)
    {
       User user=userRepository.getUserByUserName(email);
        if(user!=null)
        {
            return user;
        }
        else {
            throw new UsernameNotFoundException("Invalid UserName!!! User Not found");
        }
    }


//    private List<User> store=new ArrayList<>();
//
////    public UserService()
////    {
////        store.add(new User(UUID.randomUUID().toString(),"Anuj Yadav","Anuj123@gmail.com"));
////        store.add(new User(UUID.randomUUID().toString(),"Aman Yadav","aman123@gmail.com"));
////        store.add(new User(UUID.randomUUID().toString(),"Sumit Yadav","sumit123@gmail.com"));
////        store.add(new User(UUID.randomUUID().toString(),"Ajay Yadav","ajay123@gmail.com"));
////    }
//
//    public List<User> getUser()
//    {
//        return this.store;
//    }
}
