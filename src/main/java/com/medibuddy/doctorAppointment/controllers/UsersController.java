package com.medibuddy.doctorAppointment.controllers;


import com.medibuddy.doctorAppointment.entities.Address;
import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.entities.Doctor;
import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.paylods.ApiResponse;
import com.medibuddy.doctorAppointment.paylods.UserDto;
import com.medibuddy.doctorAppointment.repositories.AppointmnetRepository;
import com.medibuddy.doctorAppointment.repositories.DoctorRepository;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import com.medibuddy.doctorAppointment.services.UsersService;
import com.medibuddy.doctorAppointment.utils.JsonMessage;
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

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmnetRepository appointmnetRepository;

    @GetMapping("/test")
    public User test(){
//        Doctor d1 = new Doctor(1,"Modi","General");
//        d1 = doctorRepository.save(d1);
//
//        User u1 = usersRepository.findById(4).get();
//        Appointment a = new Appointment();
//
//        a.setUser(u1);
//        a.setDoctor(d1);
//
//        d1.getAppointments().add(a);
//        u1.getAppointmentList().add(a);
//
//        appointmnetRepository.save(a);

        return appointmnetRepository.findById(25).get().getUser();







    }



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
    public ResponseEntity<ApiResponse<UserDto>> addUser(@Valid @RequestBody UserDto userDto){

            UserDto createdUserDto = usersService.addUser(userDto);
            return new ResponseEntity<>(
                    new ApiResponse<>(JsonMessage.SUCCESSFUL,createdUserDto),
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
            return new ResponseEntity<>(new ApiResponse<Void>(JsonMessage.SUCCESSFUL,null),HttpStatus.OK);

    }

}