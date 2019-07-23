/**
 * @(#)Privilege.java	0.0.1, 11-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class Privilege {
    
    private int priId;
    private String priName;
    private int priDiscountPct;

    public Privilege() {
    }
    
    public Privilege(int priId, String priName, int priDiscountPot) {
        this.priId = priId;
        this.priName = priName;
        this.priDiscountPct = priDiscountPot;
    }

    public int getPriId() {
        return priId;
    }

    public void setPriId(int priId) {
        this.priId = priId;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public int getPriDiscountPct() {
        return priDiscountPct;
    }

    public void setPriDiscountPct(int priDiscountPct) {
        this.priDiscountPct = priDiscountPct;
    }

    
    
    @Override
    public String toString() {
        return "Privilege{" + "priId=" + priId + ", priName=" + priName 
                + ", priDiscountPct=" + priDiscountPct + '}';
    }
    
    
    
    
    
}
