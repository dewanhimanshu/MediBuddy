package com.medibuddy.doctorAppointment.repositories;

import com.medibuddy.doctorAppointment.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "with recursive managers as " +
            "(select id as emp_id, name as emp_name, manager_id , designation as emp_role, 1 as level  from employee e where id =:var  " +
            "union  " +
            "select e.id as emp_id, e.name as emp_name, e.manager_id  , e.designation as emp_role, level+1 as level  from employee e join managers m on m.manager_id = e.id) " +
            "select * from managers;",
            nativeQuery = true)
    List<Object> getAllSeniors(@Param("var") int empId);

    @Query(value = "with recursive managers as " +
            "(select id as emp_id, name as emp_name, manager_id , designation as emp_role, 1 as level  from employee e where id =:var " +
            "union  " +
            "select e.id as emp_id, e.name as emp_name, e.manager_id  , e.designation as emp_role, level+1 as level  from employee e join managers m on m.emp_id = e.manager_id) " +
            "select * from managers;",
            nativeQuery = true)
    public Set<Map<String,Object>> getAllJuniors(@Param("var") int empId );


}
