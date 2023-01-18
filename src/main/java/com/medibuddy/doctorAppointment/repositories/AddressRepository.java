package com.medibuddy.doctorAppointment.repositories;

import com.medibuddy.doctorAppointment.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
