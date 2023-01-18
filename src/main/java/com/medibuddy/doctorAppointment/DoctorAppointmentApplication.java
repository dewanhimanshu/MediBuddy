package com.medibuddy.doctorAppointment;

import com.medibuddy.doctorAppointment.entities.Address;
import com.medibuddy.doctorAppointment.entities.User;
import com.medibuddy.doctorAppointment.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.medibuddy.doctorAppointment.*"})
public class DoctorAppointmentApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentApplication.class, args);
	}






}
