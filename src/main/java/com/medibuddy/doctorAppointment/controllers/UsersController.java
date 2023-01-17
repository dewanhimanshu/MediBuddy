package com.medibuddy.doctorAppointment.controllers;


import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            List<User> list =  usersService.getAllUsers();
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        try{
            User user = usersService.getUser(Integer.parseInt(id));
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
            User u = usersService.addUser(user);
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user ,@PathVariable String id){
        try{
            User u = usersService.updateUser(user,Integer.parseInt(id));
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        try{
            usersService.deleteUser(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}