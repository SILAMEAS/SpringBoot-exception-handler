package com.crud.demo.controller;
import com.crud.demo.exeption.UserNotFoundException;
import com.crud.demo.model.User;
import com.crud.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return  userRepo.save(newUser);
    }
    @GetMapping("/user")
    List<User> allUsers(){
        return  userRepo.findAll();
    }
    @DeleteMapping("/user/{id}")
   List<User> deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
     return userRepo.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return  userRepo.findById(id).orElse(()->new  UserNotFoundException(id));
    }
}
