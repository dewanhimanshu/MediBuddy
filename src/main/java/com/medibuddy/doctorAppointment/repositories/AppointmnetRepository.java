package com.medibuddy.doctorAppointment.repositories;

import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.entities.Doctor;
import com.medibuddy.doctorAppointment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmnetRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findByUser(User user);
    List<Appointment> findByDoctor(Doctor doctor);
}
