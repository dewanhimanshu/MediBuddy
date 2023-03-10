package com.medibuddy.doctorAppointment.controllers;

import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.paylods.ApiResponse;
import com.medibuddy.doctorAppointment.repositories.AppointmnetRepository;
import com.medibuddy.doctorAppointment.services.AppointmentService;
import com.medibuddy.doctorAppointment.utils.JSONMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {

    @Autowired
    AppointmnetRepository appointmnetRepository;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable int id){
        return appointmentService.getAppointment(id);
    }

    @PostMapping("")
    public Appointment addAppointment(@RequestBody Map<String,String> map) throws Exception{
        return appointmentService.addAppointment(map);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(
                new ApiResponse<>(JSONMessage.SUCCESSFUL,null),
                HttpStatus.OK
        );
    }

    @GetMapping("/userId/{userId}")
    public List<Appointment> getAllAppointmentsOfUser(@PathVariable int userId){
        return appointmentService.getAllAppointmentsOfUser(userId);
    }

    @GetMapping("/doctorId/{doctorId}")
    public List<Appointment> getAllAppointmentsOfDoctor(@PathVariable int doctorId){
        return appointmentService.getAllAppointmentsOfDoctor(doctorId);
    }

}
