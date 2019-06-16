/**
 * @(#)Province.java	0.0.1, 11-Jun-2019 
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
    private List<City> proCities;

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

    public List<City> getProCities() {
        return proCities;
    }

    public void setProCities(List<City> proCities) {
        this.proCities = proCities;
    }

    public boolean createCity(City city){
        if(this.proCities == null)
            this.proCities = new ArrayList<>();
        this.proCities.add(city);
        return true;
    }
    
    public City readCity(int citIndex){
        if(this.proCities == null)
            throw new NullPointerException();
        return this.proCities.get(citIndex);
    }
    
    public boolean updateCity(int citIndex, City city){
        if(this.proCities == null)
            throw new NullPointerException();
        this.proCities.set(citIndex, city);
        return true;
    }
    
    public boolean deleteCity(int citIndex){
        if(this.proCities == null)
            throw new NullPointerException();
        this.proCities.remove(citIndex);
        return true;
    }
    
    @Override
    public String toString() {
        return "Province{" + "proId=" + proId + ", proName=" + proName + 
                ", proCities=" + proCities.toString() + '}';
    }
    
    
}
