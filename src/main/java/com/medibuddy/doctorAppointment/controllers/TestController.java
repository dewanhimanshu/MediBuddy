package com.medibuddy.doctorAppointment.controllers;

import com.medibuddy.doctorAppointment.entities.Employee;
import com.medibuddy.doctorAppointment.repositories.EmployeeRepository;
import com.medibuddy.doctorAppointment.utils.Desig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



@RestController
public class TestController {
    @Autowired
    EmployeeRepository employeeRepository;


    @Autowired
    Desig desigMap;

    @GetMapping("")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/seniors/{id}")
    public List<Object> test(@PathVariable int id){
        return employeeRepository.getAllSeniors(id);
    }

    @GetMapping("/juniors/{id}")
    public Set<Map<String,Object>> test1(@PathVariable int id){
        return employeeRepository.getAllJuniors(id);
    }

    @PostMapping("/add")
    public void addRow(@RequestBody Map<String,String> map) throws Exception{
        Employee manager = employeeRepository.findById(Integer.parseInt(map.get("managerId"))).get();
        if(desigMap.map.get(manager.getDesignation())  > desigMap.map.get(map.get("designation"))){
            throw  new Exception("Hierch not followed");
        }

    }
}
