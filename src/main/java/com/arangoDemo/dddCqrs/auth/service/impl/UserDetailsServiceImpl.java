package com.arangoDemo.dddCqrs.auth.service.impl;

import com.arangoDemo.dddCqrs.auth.model.CustomUserDetails;
import com.arangoDemo.dddCqrs.auth.model.UserInfo;
import com.arangoDemo.dddCqrs.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found: " + username);
        }
        return new CustomUserDetails(user);
    }

    public String getEmailByUsername(String username){
        UserInfo user = userRepository.findByUsername(username);
        return user.getEmail();
    }
}