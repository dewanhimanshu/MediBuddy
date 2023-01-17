package com.medibuddy.doctorAppointment.controllers;


import com.medibuddy.doctorAppointment.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class usersController {

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return null;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return null;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return null;
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user , String id){
        return null;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable String id){
        return null;
    }

}