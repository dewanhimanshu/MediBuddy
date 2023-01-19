package com.medibuddy.doctorAppointment.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
    private String specilization;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointments = new ArrayList<>();

    @JsonIgnore
    public List<Appointment> getAppointments() {
        return appointments;
    }

}
