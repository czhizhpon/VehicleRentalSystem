/**
 * @(#)VehRate.java	0.0.1, 15-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

/**
 * @since 15-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class VehRate {
    
    private double vehDayCost;
    private double vehDamageCost;

    public VehRate(double vehDayCost, double vehDamageCost) {
        this.vehDayCost = vehDayCost;
        this.vehDamageCost = vehDamageCost;
    }

    public double getVehDayCost() {
        return vehDayCost;
    }

    public void setVehDayCost(double vehDayCost) {
        this.vehDayCost = vehDayCost;
    }

    public double getVehDamageCost() {
        return vehDamageCost;
    }

    public void setVehDamageCost(double vehDamageCost) {
        this.vehDamageCost = vehDamageCost;
    }

    @Override
    public String toString() {
        return "VehRate{" + "vehDayCost=" + vehDayCost + ", vehDamageCost=" 
                + vehDamageCost + '}';
    }
    
    
}
