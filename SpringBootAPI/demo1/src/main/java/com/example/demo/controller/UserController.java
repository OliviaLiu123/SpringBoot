package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
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

    //UserRepository: 用于直接与数据库交互。它提供了基本的CRUD操作，通常不包含业务逻辑。
    //UserService: 用于封装业务逻辑。它可以调用UserRepository的方法，并在此基础上实现复杂的业务逻辑。
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }



}
