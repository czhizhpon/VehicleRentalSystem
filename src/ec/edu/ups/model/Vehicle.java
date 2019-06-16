/**
 * @(#)Vehicle.java	0.0.1, 11-Jun-2019 
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
public class Vehicle {
    
    private int vehId;
    private String vehPlate;
    private String vehColor;
    private char vehStatus;
    private double vehKilometraje;
    private VehRate vehRate;

    public Vehicle(int vehId, String vehPlate, String vehColor, char vehStatus, double vehKilometraje, VehRate vehRate) {
        this.vehId = vehId;
        this.vehPlate = vehPlate;
        this.vehColor = vehColor;
        this.vehStatus = vehStatus;
        this.vehKilometraje = vehKilometraje;
        this.vehRate = vehRate;
    }

    public int getVehId() {
        return vehId;
    }

    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    public String getVehPlate() {
        return vehPlate;
    }

    public void setVehPlate(String vehPlate) {
        this.vehPlate = vehPlate;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public char getVehStatus() {
        return vehStatus;
    }

    public void setVehStatus(char vehStatus) {
        this.vehStatus = vehStatus;
    }

    public double getVehKilometraje() {
        return vehKilometraje;
    }

    public void setVehKilometraje(double vehKilometraje) {
        this.vehKilometraje = vehKilometraje;
    }

    public VehRate getVehRate() {
        return vehRate;
    }

    public void setVehRate(VehRate vehRate) {
        this.vehRate = vehRate;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vehId=" + vehId + ", vehPlate=" + vehPlate 
                + ", vehColor=" + vehColor + ", vehStatus=" + vehStatus 
                + ", vehKilometraje=" + vehKilometraje + ", vehRate=" 
                + vehRate.toString() + '}';
    }

    
}
