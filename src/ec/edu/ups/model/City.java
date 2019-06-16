/**
 * @(#)City.java	0.0.1, 11-Jun-2019 
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
public class City {
    
    private int citId;
    private String citName;
    private List<Office> citOffices;

    public City(int citId, String citName) {
        this.citId = citId;
        this.citName = citName;
    }

    public int getCitId() {
        return citId;
    }

    public void setCitId(int citId) {
        this.citId = citId;
    }

    public String getCitName() {
        return citName;
    }

    public void setCitName(String citName) {
        this.citName = citName;
    }

    public List<Office> getCitOffices() {
        return citOffices;
    }

    public void setCitOffices(List<Office> citOffices) {
        this.citOffices = citOffices;
    }
    
    public boolean createOffice(Office office){
        if (this.citOffices == null)
            this.citOffices = new ArrayList<>();
        this.citOffices.add(office);
        return true;
    }
    
    public Office readOffice(int offIndex){
        if (this.citOffices == null)
            throw new NullPointerException();
        return this.citOffices.get(offIndex);
    }
    
    public boolean updateOffice(int offIndex, Office office){
        if (this.citOffices == null)
            throw new NullPointerException();
        this.citOffices.set(offIndex, office);
        return true;
    }
    
    public boolean deleteOffice(int offIndex){
        if (this.citOffices == null)
            throw new NullPointerException();
        this.citOffices.remove(offIndex);
        return true;
    }

    @Override
    public String toString() {
        return "City{" + "citId=" + citId + ", citName=" + citName 
                + ", citOffices=" + citOffices +'}';
    }
    
    
    
}
