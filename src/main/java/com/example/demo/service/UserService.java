package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> createUser(User user){
        userRepository.save(user);
        return null;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
