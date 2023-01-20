package com.medibuddy.doctorAppointment.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Desig {
    public HashMap<String,Integer > map = new HashMap<>();
    Desig(){
        map.put("CEO",1);
        map.put("CTO",2);
        map.put("Manager",3);
        map.put("SE",4);
    }
}
