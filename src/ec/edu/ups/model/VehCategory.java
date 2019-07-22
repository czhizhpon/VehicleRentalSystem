/**
 * @(#)VehCategory.java	0.0.1, 11-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;


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
    private int catWarrantyPct;

    public VehCategory(int catId, String catName, String catDescription, double catDayCost, double catDamageCost, int catWarrantyPct) {
        this.catId = catId;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catDayCost = catDayCost;
        this.catDamageCost = catDamageCost;
        this.catWarrantyPct = catWarrantyPct;
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

    public int getCatWarrantyPct() {
        return catWarrantyPct;
    }

    public void setCatWarrantyPct(int catWarrantyPct) {
        this.catWarrantyPct = catWarrantyPct;
    }

    @Override
    public String toString() {
        return "VehCategory{" + "catId=" + catId + ", catName=" + catName 
                + ", catDescription=" + catDescription + ", catDayCost=" 
                + catDayCost + ", catDamageCost=" + catDamageCost 
                + ", catWarrantyPct=" + catWarrantyPct + '}';
    }

    
    
    
}
