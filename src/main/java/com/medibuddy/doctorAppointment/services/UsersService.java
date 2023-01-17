package com.medibuddy.doctorAppointment.services;

import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    public User getUser(int id){
        return usersRepository.findById(id).get();
    }

    public User addUser(User user){
        return usersRepository.save(user);
    }

    public User updateUser(User user , int Id){
        return usersRepository.save(user);
    }

    public void deleteUser(int id){
        usersRepository.deleteById(id);
        return;
    }
}
