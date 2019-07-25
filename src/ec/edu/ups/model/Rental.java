/**
 * @(#)Rental.java	0.0.1, 11-Jun-2019 
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
public class Rental {
    
    private int renId;
    private double renKilometrajeIni;
    private double renKilometrajeFin;
    private Date renDateIni;
    private Date renDateFin;
    private double renWarranty;
    private char renStatus;
    private Customer renCustomer;
    private Vehicle renVehicle;
    private Reservation renReservation;
    private PaymentMethod renPayMeth;

    public Rental() {
    }
    
    public int getRenId() {
        return renId;
    }

    public void setRenId(int renId) {
        this.renId = renId;
    }

    public double getRenKilometrajeIni() {
        return renKilometrajeIni;
    }

    public void setRenKilometrajeIni(double renKilometrajeIni) {
        this.renKilometrajeIni = renKilometrajeIni;
    }

    public double getRenKilometrajeFin() {
        return renKilometrajeFin;
    }

    public void setRenKilometrajeFin(double renKilometrajeFin) {
        this.renKilometrajeFin = renKilometrajeFin;
    }

    public Date getRenDateIni() {
        return renDateIni;
    }

    public void setRenDateIni(Date renDateIni) {
        this.renDateIni = renDateIni;
    }

    public Date getRenDateFin() {
        return renDateFin;
    }

    public void setRenDateFin(Date renDateFin) {
        this.renDateFin = renDateFin;
    }

    public double getRenWarranty() {
        return renWarranty;
    }

    public void setRenWarranty(double renWarranty) {
        this.renWarranty = renWarranty;
    }

    public char getRenStatus() {
        return renStatus;
    }

    public void setRenStatus(char renStatus) {
        this.renStatus = renStatus;
    }

    public Customer getRenCustomer() {
        return renCustomer;
    }

    public void setRenCustomer(Customer renCustomer) {
        this.renCustomer = renCustomer;
    }
    
    public Vehicle getRenVehicle() {
        return renVehicle;
    }

    public void setRenVehicle(Vehicle renVehicle) {
        this.renVehicle = renVehicle;
    }

    public Reservation getRenReservation() {
        return renReservation;
    }

    public void setRenReservation(Reservation renReservation) {
        this.renReservation = renReservation;
    }

    public PaymentMethod getRenPayMeth() {
        return renPayMeth;
    }

    public void setRenPayMeth(PaymentMethod renPayMeth) {
        this.renPayMeth = renPayMeth;
    }
    
    @Override
    public String toString() {
        return "Rental{" + "renId=" + renId + ", renKilometrajeIni=" 
                + renKilometrajeIni + ", renKilometrajeFin=" + renKilometrajeFin 
                + ", renDateIni=" + renDateIni + ", renDateFin=" + renDateFin 
                + ", renVehicle=" + renVehicle.toString() + ", renReservation=" 
                + renReservation.toString() + '}';
    }
    
    
    
    
    
}
