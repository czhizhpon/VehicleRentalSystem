/**
 * @(#)Province.java	0.0.1, 16-Jun-2019 
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
public class Province {
    
    private int proId;
    private String proName;

    public Province(int proId, String proName) {
        this.proId = proId;
        this.proName = proName;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
    
    @Override
    public String toString() {
        return "Province{" + "proId=" + proId + ", proName=" + proName + '}';
    }
    
    
}
