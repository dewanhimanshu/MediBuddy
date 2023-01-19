package com.medibuddy.doctorAppointment.controllers;



import com.medibuddy.doctorAppointment.paylods.ApiResponse;
import com.medibuddy.doctorAppointment.paylods.UserDto;

import com.medibuddy.doctorAppointment.services.UsersService;
import com.medibuddy.doctorAppointment.utils.JSONMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers(
            @RequestParam(value = "pageNumber" , defaultValue = "0" , required = false) int pageNumber,
            @RequestParam(value = "pageSize" , defaultValue = "5" , required = false) int pageSize
    ){
            List<UserDto> list =  usersService.getAllUsers(pageNumber,pageSize);
            return new ResponseEntity<ApiResponse<List<UserDto>>>(new ApiResponse<>(JSONMessage.SUCCESSFUL,list) , HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUser(@PathVariable String id){
            UserDto userDto = usersService.getUser(Integer.parseInt(id));
            return new ResponseEntity<ApiResponse<UserDto>>(new ApiResponse<>(JSONMessage.SUCCESSFUL,userDto), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse<UserDto>> addUser(@Valid @RequestBody UserDto userDto){

            UserDto createdUserDto = usersService.addUser(userDto);
            return new ResponseEntity<>(
                    new ApiResponse<>(JSONMessage.SUCCESSFUL,createdUserDto),
                    HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto ,@PathVariable String id){

            UserDto updatedUserDto= usersService.updateUser(userDto,Integer.parseInt(id));
            return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable String id){

            usersService.deleteUser(Integer.parseInt(id));
            return new ResponseEntity<>(new ApiResponse<Void>(JSONMessage.SUCCESSFUL,null),HttpStatus.OK);

    }

}