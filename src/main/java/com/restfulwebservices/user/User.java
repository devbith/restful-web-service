package com.restfulwebservices.user;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class User {

    private Long id;

    @Size(min = 2, message = "name should have at least two character")
    private String name;

    @Past(message = "dateofBirth should be of past date")
    private LocalDate dateOfBirth;

    @JsonIgnore
    @Size(min = 8, max =20,  message = "password should be at least 8 character long")
    private String password;

    public User(Long id, String name, LocalDate dateOfBirth, String password) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
