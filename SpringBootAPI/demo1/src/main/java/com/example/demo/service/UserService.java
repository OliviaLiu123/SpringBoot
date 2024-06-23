package com.example.demo.service;

/*
SpringBoot 中 集成和使用JPA 进行数据库操作的基本步骤
 */

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServices{


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
@Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("张三");
        return user;
    }





}
