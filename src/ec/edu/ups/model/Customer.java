/**
 * @(#)Customer.java	0.0.1, 16-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.Date;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class Customer extends User{
    
    private String useWorkAdd;
    private Privilege usePrivilege;

    public Customer() {
    }

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
