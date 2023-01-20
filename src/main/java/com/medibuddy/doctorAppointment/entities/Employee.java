package com.medibuddy.doctorAppointment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Employee  implements Serializable {
    @Id
    int id;

    String name;


    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
    @JsonManagedReference
    private Employee manager;


    @OneToMany(mappedBy="manager")
    @JsonBackReference
    private Set<Employee> subordinates = new HashSet<Employee>();

    String designation;


}
