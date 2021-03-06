/**
 * @(#)Employee.java	0.0.2, 16-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.Date;

/**
 * @since   11-Jun-2019
 * @version 0.0.2
 * @author  Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class Employee extends User{
    
    public Employee() {
        
    }

    public Employee(int useId, String useDNI, String useName, String useLastNamel, 
            Date useBirthDay, String useAddress, char useType, String useEmail, 
            String usePassword) {
        super(useId, useDNI, useName, useLastNamel, useBirthDay, useAddress, 
                useType, useEmail, usePassword);
    }
    
}
