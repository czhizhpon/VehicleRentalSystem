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
    private List<Reservation> vehReservations;
    private List<Rental> vehRentals;

    public Vehicle(int vehId, String vehPlate, String vehColor, char vehStatus, 
            double vehKilometraje) {
        this.vehId = vehId;
        this.vehPlate = vehPlate;
        this.vehColor = vehColor;
        this.vehStatus = vehStatus;
        this.vehKilometraje = vehKilometraje;
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

    public List<Reservation> getVehReservations() {
        return vehReservations;
    }

    public void setVehReservations(List<Reservation> vehReservations) {
        this.vehReservations = vehReservations;
    }

    public List<Rental> getVehRentals() {
        return vehRentals;
    }

    public void setVehRentals(List<Rental> vehRentals) {
        this.vehRentals = vehRentals;
    }

    public boolean createReservation(Reservation reservation){
        if (this.vehReservations == null)
            this.vehReservations = new ArrayList<>();
        this.vehReservations.add(reservation);
        return true;
    }
    
    public Reservation readReservation(int resId){
        if (this.vehReservations == null)
            throw new NullPointerException();
        return this.vehReservations.get(resId);
    }
    
    public boolean updateReservation(int resId, Reservation reservation){
        if (this.vehReservations == null)
            throw new NullPointerException();
        this.vehReservations.set(resId, reservation);
        return true;
    }
    
    public boolean deleteReservation(int resId){
        if (this.vehReservations == null)
            throw new NullPointerException();
        this.vehReservations.remove(resId);
        return true;
    }
    
    public boolean createRental(Rental rental){
        if (this.vehRentals == null)
            this.vehRentals = new ArrayList<>();
        this.vehRentals.add(rental);
        return true;
    }
    
    public Rental readRental(int renId){
        if (this.vehRentals == null)
            throw new NullPointerException();
        return this.vehRentals.get(renId);
    }
    
    public boolean updateRental(int renId, Rental rental){
        if (this.vehRentals == null)
            throw new NullPointerException();
        this.vehRentals.set(renId, rental);
        return true;
    }
    
    public boolean deleteRental(int renId){
        if (this.vehRentals == null)
            throw new NullPointerException();
        this.vehRentals.remove(renId);
        return true;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" + "vehId=" + vehId + ", vehPlate=" + vehPlate 
                + ", vehColor=" + vehColor + ", vehStatus=" + vehStatus 
                + ", vehKilometraje=" + vehKilometraje + ", vehReservations=" 
                + vehReservations + ", vehRentals=" + vehRentals + '}';
    }
    
    
    
}
