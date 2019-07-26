/**
 * @(#)Vehicle.java	0.0.1, 11-Jun-2019 
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
public class Vehicle {
    
    private int vehId;
    private String vehPlate;
    private String vehColor;
    private char vehStatus;
    private double vehKilometraje;
    private String vehInsurranceNumber;
    private Date vehInsurranceDate;
    private Date vehInsurranceExpires;
    private char vehOrigin;
    private Model vehModel;
    private VehCategory vehCategory;

    public Vehicle() {
    }

    public Vehicle(int vehId, String vehPlate, String vehColor, char vehStatus, 
            double vehKilometraje, String vehInsurranceNumber, Date vehInsurranceDate, 
            Date vehInsurranceExpires, char vehOrigin, VehCategory vehCategory) {
        this.vehId = vehId;
        this.vehPlate = vehPlate;
        this.vehColor = vehColor;
        this.vehStatus = vehStatus;
        this.vehKilometraje = vehKilometraje;
        this.vehInsurranceNumber = vehInsurranceNumber;
        this.vehInsurranceDate = vehInsurranceDate;
        this.vehInsurranceExpires = vehInsurranceExpires;
        this.vehOrigin = vehOrigin;
        this.vehCategory = vehCategory;
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

    public Model getVehModel() {
        return vehModel;
    }

    public void setVehModel(Model vehModel) {
        this.vehModel = vehModel;
    }

    public VehCategory getVehCategory() {
        return vehCategory;
    }

    public void setVehCategory(VehCategory vehCategory) {
        this.vehCategory = vehCategory;
    }

    public String getVehInsurranceNumber() {
        return vehInsurranceNumber;
    }

    public void setVehInsurranceNumber(String vehInsurranceNumber) {
        this.vehInsurranceNumber = vehInsurranceNumber;
    }

    public Date getVehInsurranceDate() {
        return vehInsurranceDate;
    }

    public void setVehInsurranceDate(Date vehInsurranceDate) {
        this.vehInsurranceDate = vehInsurranceDate;
    }

    public Date getVehInsurranceExpires() {
        return vehInsurranceExpires;
    }

    public void setVehInsurranceExpires(Date vehInsurranceExpires) {
        this.vehInsurranceExpires = vehInsurranceExpires;
    }

    public char getVehOrigin() {
        return vehOrigin;
    }

    public void setVehOrigin(char vehOrigin) {
        this.vehOrigin = vehOrigin;
    }
    
    

    @Override
    public String toString() {
        return "Vehicle{" + "vehId=" + vehId + ", vehPlate=" + vehPlate 
                + ", vehColor=" + vehColor + ", vehStatus=" + vehStatus 
                + ", vehKilometraje=" + vehKilometraje + ", vehInsurranceNumber=" 
                + vehInsurranceNumber + ", vehInsurranceDate=" + vehInsurranceDate 
                + ", vehInsurranceExpires=" + vehInsurranceExpires 
                + ", vehCategory=" + vehCategory + '}';
    }
    
    

    
}
