package com.medibuddy.doctorAppointment.services;

import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.entities.Doctor;
import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.repositories.AppointmnetRepository;
import com.medibuddy.doctorAppointment.repositories.DoctorRepository;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {
    @Autowired
    AppointmnetRepository appointmnetRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DoctorRepository doctorRepository;

    

    public Appointment addAppointment(Map<String,String> map){
        User user = usersRepository.findById(Integer.valueOf(map.get("userId"))).get();
        Doctor doctor = doctorRepository.findById(Integer.valueOf(map.get("doctorId"))).get();

        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setDoctor(doctor);
        appointment.setPlace(map.getOrDefault("place",""));
        return  appointmnetRepository.save(appointment);

    }
}
