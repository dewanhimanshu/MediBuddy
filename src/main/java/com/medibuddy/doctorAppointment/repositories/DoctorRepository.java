package com.medibuddy.doctorAppointment.repositories;

import com.medibuddy.doctorAppointment.entities.Appointment;
import com.medibuddy.doctorAppointment.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
