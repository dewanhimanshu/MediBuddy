package com.medibuddy.doctorAppointment.services;

import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.exceptions.ResourceNotFoundException;
import com.medibuddy.doctorAppointment.paylods.UserDto;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<UserDto> getAllUsers(int pageNumber , int pageSize , String sortBy , String sortDir){

        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<User> list = usersRepository.findAll(PageRequest.of(pageNumber,pageSize,sort)).getContent();
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
        User savedUser = usersRepository.save(user);
        return userToUserDto(savedUser);
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
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

    public User userDtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        return user;
    }

}

