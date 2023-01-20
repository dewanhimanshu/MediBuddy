package com.medibuddy.doctorAppointment.services;

import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.entities.Doctor;
import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.repositories.AppointmnetRepository;
import com.medibuddy.doctorAppointment.repositories.DoctorRepository;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
    AppointmnetRepository appointmnetRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public List<Appointment> getAllAppointments(){
        return appointmnetRepository.findAll().stream().collect(Collectors.toList());
    }

    public Appointment getAppointment(int id){
        return appointmnetRepository.findById(id).get();
    }

    public Appointment addAppointment(Map<String,String> map) throws Exception {
        User user = usersRepository.findById(Integer.valueOf(map.get("userId"))).get();
        Doctor doctor = doctorRepository.findById(Integer.valueOf(map.get("doctorId"))).get();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate appointmentDate = LocalDate.parse(map.get("date"), formatter);


        if(appointmentDate.isBefore(LocalDate.now())) {
            throw new Exception("Date cant be before today");
        }

        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime appointmentTime = LocalTime.parse(map.get("time"), formatter);

        if(appointmentTime.isBefore(LocalTime.now())) {
            throw new Exception("Time cant be before Now");
        }

        //check wheter that slot is empty (10 mins)
        for(Appointment  doctorAppointment : doctor.getAppointments()){
            if(appointmentDate.equals(doctorAppointment.getAppointmentDate())){
                if( appointmentTime.isAfter(doctorAppointment.getAppointmentTime().minusMinutes(10))  &&
                        (appointmentTime.isBefore(doctorAppointment.getAppointmentTime().plusMinutes(10)))
                ){
                    throw new Exception("Doctor is Busy At This Time");
                }

            }
        }


        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setDoctor(doctor);
        appointment.setPlace(map.getOrDefault("place",""));
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);

        return  appointmnetRepository.save(appointment);

    }

    public void deleteAppointment(int id) {
        appointmnetRepository.deleteById(id);
    }

    public List<Appointment> getAllAppointmentsOfUser(int userId) {
        User user = usersRepository.findById(userId).get();
        return appointmnetRepository.findByUser(user);
    }

    public List<Appointment> getAllAppointmentsOfDoctor(int doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return appointmnetRepository.findByDoctor(doctor);
    }
}
