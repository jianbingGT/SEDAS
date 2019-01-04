package com.sedationassist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sedationassist.model.User;
import com.sedationassist.repositories.UserRepo;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<String> list = new ArrayList<String>();
		list.add("USER");  
        user.setRole(list);
        userRepository.save(user);
        System.out.println(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}