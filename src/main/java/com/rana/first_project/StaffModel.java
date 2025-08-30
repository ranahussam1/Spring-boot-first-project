package com.rana.first_project;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class StaffModel{
    private String id;
    @NotBlank(message="Staff name can not be blank")
    private String name;
    @NotBlank(message="Staff title can not be blank")    
    private String title;
    private double salary;

    public StaffModel() {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
}