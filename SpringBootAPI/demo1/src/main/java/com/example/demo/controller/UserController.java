package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
1.在Spring boot 中GET 和POST Method 的url是一样的
2.如下例子可以看出都是http://localhost:8080/api/users
只是POST测试的时候要添加相应的信息
 */

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping   // GET METHOD
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping  //POST METHOD
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }


}
