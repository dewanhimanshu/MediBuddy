package com.medibuddy.doctorAppointment.entities;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String city;
    private String country;

    @OneToOne
    private User user;

}
