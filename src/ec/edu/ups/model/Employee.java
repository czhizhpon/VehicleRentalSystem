/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.model;

import java.util.Date;

/**
 *
 * @author edd
 */
public class Employee extends User{
    
    private String empRole;

    public Employee(int useId, String useDNI, String useName, String useLastNamel, 
            Date useBirthDay, String useAddress, char useType, String useEmail, 
            String usePassword) {
        super(useId, useDNI, useName, useLastNamel, useBirthDay, useAddress, 
                useType, useEmail, usePassword);
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    @Override
    public String toString() {
        return "Employee{" + "empRole=" + empRole + "employee=" + super.toString() +'}';
    }
    
}
