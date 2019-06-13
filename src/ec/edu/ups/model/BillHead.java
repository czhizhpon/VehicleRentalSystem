/**
 * @(#)BillHead.java	0.0.1, 11-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class BillHead {
    
    private int heaId;
    private double heaSubtotal;
    private double heaVat;
    private double heaTotal;
    private Date heaDate;
    private List<Rental> heaRentals;

    public BillHead(int heaId, double heaSubtotal, double heaVat, 
            double heaTotal, Date heaDate) {
        this.heaId = heaId;
        this.heaSubtotal = heaSubtotal;
        this.heaVat = heaVat;
        this.heaTotal = heaTotal;
        this.heaDate = heaDate;
    }
    
    public int getHeaId() {
        return heaId;
    }

    public void setHeaId(int heaId) {
        this.heaId = heaId;
    }

    public double getHeaSubtotal() {
        return heaSubtotal;
    }

    public void setHeaSubtotal(double heaSubtotal) {
        this.heaSubtotal = heaSubtotal;
    }

    public double getHeaVat() {
        return heaVat;
    }

    public void setHeaVat(double heaVat) {
        this.heaVat = heaVat;
    }

    public double getHeaTotal() {
        return heaTotal;
    }

    public void setHeaTotal(double heaTotal) {
        this.heaTotal = heaTotal;
    }

    public Date getHeaDate() {
        return heaDate;
    }

    public void setHeaDate(Date heaDate) {
        this.heaDate = heaDate;
    }

    public List<Rental> getHeaRentals() {
        return heaRentals;
    }

    public void setHeaRentals(List<Rental> heaRentals) {
        this.heaRentals = heaRentals;
    }

    public boolean createRental(Rental rental){
        if (this.heaRentals == null)
            this.heaRentals = new ArrayList<>();
        this.heaRentals.add(rental);
        return true;
    }
    
    public Rental readRental(int heaId){
        if (this.heaRentals == null) 
            throw new NullPointerException("There is not rentals yet");
        return this.heaRentals.get(heaId);
    }
    
    public boolean updateRental(int heaId, Rental rental){
        if (this.heaRentals == null) 
            throw new NullPointerException("There is not rentals yet");
        this.heaRentals.set(heaId, rental);
        return true;
    }
    
    public boolean deleteRental (int heaId){
        if (this.heaRentals == null) 
            throw new NullPointerException("There is not rentals yet");
        this.heaRentals.remove(heaId);
        return true;
    }
    
    @Override
    public String toString() {
        return "BillHead{" + "heaId=" + heaId + ", heaSubtotal=" + heaSubtotal 
                + ", heaVat=" + heaVat + ", heaTotal=" + heaTotal + ", heaDate=" 
                + heaDate + ", heaRentals=" + heaRentals + '}';
    }
    
}
