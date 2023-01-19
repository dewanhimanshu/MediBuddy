package com.medibuddy.doctorAppointment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
    private String email;
    private String password;

//    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
//    private Address address;
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user")
    List<Appointment> appointmentList = new ArrayList<>();

    @JsonIgnore
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }


}
