/**
 * @(#)VehCategory.java	0.0.1, 11-Jun-2019 
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
public class VehCategory {
    
    private int catId;
    private String catName;
    private String catDescription;
    private double catDayCost;
    private double catDamageCost;
    private List<Vehicle> catVehicles;

    public VehCategory(int catId, String catName, String catDescription, 
            double catDayCost, double catDamageCost) {
        this.catId = catId;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catDayCost = catDayCost;
        this.catDamageCost = catDamageCost;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public double getCatDayCost() {
        return catDayCost;
    }

    public void setCatDayCost(double catDayCost) {
        this.catDayCost = catDayCost;
    }

    public double getCatDamageCost() {
        return catDamageCost;
    }

    public void setCatDamageCost(double catDamageCost) {
        this.catDamageCost = catDamageCost;
    }

    public List<Vehicle> getCatVehicles() {
        return catVehicles;
    }

    public void setCatVehicles(List<Vehicle> catVehicles) {
        this.catVehicles = catVehicles;
    }

    public boolean createVehicle(Vehicle vehicle){
        if (this.catVehicles == null)
            this.catVehicles = new ArrayList<>();
        this.catVehicles.add(vehicle);
        return true;
    }
    
    public Vehicle read(int vehId){
        if (this.catVehicles == null)
            throw new NullPointerException();
        return this.catVehicles.get(vehId);
    }
    
    public boolean updateVehicle(int vehId, Vehicle vehicle){
        if (this.catVehicles == null)
            throw new NullPointerException();
        this.catVehicles.set(vehId, vehicle);
        return true;
    }
    
    public boolean deleteVehicle(int vehId){
        if (this.catVehicles == null)
            throw new NullPointerException();
        this.catVehicles.remove(vehId);
        return true;
    }
    
    @Override
    public String toString() {
        return "VehCategory{" + "catId=" + catId + ", catName=" + catName 
                + ", catDescription=" + catDescription + ", catDayCost=" 
                + catDayCost + ", catDamageCost=" + catDamageCost 
                + ", catVehicles=" + catVehicles + '}';
    }
    
    
    
}
