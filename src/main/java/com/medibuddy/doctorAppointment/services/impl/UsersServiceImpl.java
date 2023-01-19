package com.medibuddy.doctorAppointment.services.impl;

import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.exceptions.ResourceNotFoundException;
import com.medibuddy.doctorAppointment.paylods.UserDto;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl {

    @Autowired
    UsersRepository usersRepository;

    public List<UserDto> getAllUsers(){
        List<User> list = usersRepository.findAll();
        return list.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
    }

    public UserDto getUser(int userId){
        User user;
        try{
            user = usersRepository.findById(userId).get();
        }catch (Exception e){
            throw  new ResourceNotFoundException("User","UserID",String.valueOf(userId));
        }

        return userToUserDto(user);
    }

    public UserDto addUser(UserDto userDto){
        User user = userDtoToUser(userDto);
        return userToUserDto(usersRepository.save(user));
    }

    public UserDto updateUser(UserDto userDto , int userId){
        User user;
        try{
            user = usersRepository.findById(userId).get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            User savedUser = usersRepository.save(user);
            return this.userToUserDto(savedUser);
        }catch (Exception e){
            throw  new ResourceNotFoundException("User","UserID",String.valueOf(userId));
        }

    }

    public void deleteUser(int userId){
        try{
            User user = usersRepository.findById(userId).get();
            usersRepository.deleteById(userId);
        }catch (Exception e){
            throw  new ResourceNotFoundException("User","UserID",String.valueOf(userId));
        }
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

}
