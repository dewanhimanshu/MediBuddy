package com.medibuddy.doctorAppointment.controllers;

import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.repositories.AppointmnetRepository;
import com.medibuddy.doctorAppointment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {

    @Autowired
    AppointmnetRepository appointmnetRepository;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/{id}")
    public Map<String,String> getAppointment(@PathVariable int id){
        Appointment appointment = appointmnetRepository.findById(id).get();
        Map<String,String> map = new HashMap<>();
        map.put("data",appointment.getUser().toString());
        map.put("data1",appointment.getDoctor().toString());
        return map;
    }

    @PostMapping("")
    public Appointment addAppointment(@RequestBody Map<String,String> map){
        return appointmentService.addAppointment(map);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteAppointment(@PathVariable int id){
        return null;
    }

}
