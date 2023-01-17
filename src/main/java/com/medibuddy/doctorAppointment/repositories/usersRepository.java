package com.medibuddy.doctorAppointment.repositories;

import com.medibuddy.doctorAppointment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<User,Integer> {

}
