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
public class Customer extends User{
    
    private String useWorkAdd;
    private Privilege usePrivilege;

    public Customer(int useId, String useDNI, String useName, String useLastNamel, 
            Date useBirthDay, String useAddress, char useType, String useEmail, 
            String usePassword) {
        
        super(useId, useDNI, useName, useLastNamel, useBirthDay, useAddress, 
                useType, useEmail, usePassword);
    }

    public String getUseWorkAdd() {
        return useWorkAdd;
    }

    public void setUseWorkAdd(String useWorkAdd) {
        this.useWorkAdd = useWorkAdd;
    }

    public Privilege getUsePrivilege() {
        return usePrivilege;
    }

    public void setUsePrivilege(Privilege usePrivilege) {
        this.usePrivilege = usePrivilege;
    }

    @Override
    public String toString() {
        return "Customer{" + "useWorkAdd=" + useWorkAdd + ", usePrivilege=" 
                + usePrivilege.toString() + ", customer=" + super.toString() +'}';
    }
    
}
