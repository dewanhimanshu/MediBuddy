package com.medibuddy.doctorAppointment.paylods;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {

    private int id;
    @NotEmpty(message = "name cant be empty or null")
    private String name;
    @Email(message = "should be valid email")
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
