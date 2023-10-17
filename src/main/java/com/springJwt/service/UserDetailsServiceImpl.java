package com.springJwt.service;

import com.springJwt.models.User;
import com.springJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//    }
    @Autowired
    private UserRepository userRepository;

//    public UserDetailsServiceImpl() {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //fetching user from  db
       User user= userRepository.getUserByUserName(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Could not found user !!");
        }
        CustomUserDetails customUserDetails= new CustomUserDetails(user);
        return customUserDetails ;
    }
}
