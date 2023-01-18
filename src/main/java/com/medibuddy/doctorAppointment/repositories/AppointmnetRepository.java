package com.medibuddy.doctorAppointment.repositories;

import com.medibuddy.doctorAppointment.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmnetRepository extends JpaRepository<Appointment,Integer> {
}
