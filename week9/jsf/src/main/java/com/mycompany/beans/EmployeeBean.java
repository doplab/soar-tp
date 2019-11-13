/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alpha
 */
@Named(value = "employeeBean")
@RequestScoped
public class EmployeeBean implements Serializable {

   

    /**
     * Creates a new instance of EmployeeBean
     */
    
    private String firstName, lastName, position;
    
     public EmployeeBean() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.position = "IT Manager";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    
}
