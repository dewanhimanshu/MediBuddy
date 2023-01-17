package com.medibuddy.doctorAppointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.medibuddy.doctorAppointment.*"})
public class DoctorAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentApplication.class, args);
	}

}
