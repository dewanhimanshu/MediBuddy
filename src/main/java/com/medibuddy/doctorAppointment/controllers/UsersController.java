package com.medibuddy.doctorAppointment.controllers;


import com.medibuddy.doctorAppointment.paylods.ApiResponse;
import com.medibuddy.doctorAppointment.paylods.UserDto;
import com.medibuddy.doctorAppointment.services.UsersService;
import com.medibuddy.doctorAppointment.utils.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers(){
            List<UserDto> list =  usersService.getAllUsers();
            return new ResponseEntity<ApiResponse<List<UserDto>>>(new ApiResponse<>(JsonMessage.SUCCESSFUL,list) , HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUser(@PathVariable String id){
            UserDto userDto = usersService.getUser(Integer.parseInt(id));
            return new ResponseEntity<ApiResponse<UserDto>>(new ApiResponse<>(JsonMessage.SUCCESSFUL,userDto), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse<UserDto>> addUser(@RequestBody UserDto userDto){

            UserDto createdUserDto = usersService.addUser(userDto);
            return new ResponseEntity<>(
                    new ApiResponse<>(JsonMessage.SUCCESSFUL,createdUserDto),
                    HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto ,@PathVariable String id){

            UserDto updatedUserDto= usersService.updateUser(userDto,Integer.parseInt(id));
            return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable String id){

            usersService.deleteUser(Integer.parseInt(id));
            System.out.println("Run");
            return new ResponseEntity<>(new ApiResponse<Void>(JsonMessage.SUCCESSFUL,null),HttpStatus.OK);

    }

}