/**
 * @(#)Reservation.java	0.0.1, 11-Jun-2019 
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
public class Reservation {
    
    private int resId;
    private Date resDateIni;
    private Date resDateFin;
    private Customer resCustomer;
    private Vehicle resVehicle;

    public Reservation() {
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Date getResDateIni() {
        return resDateIni;
    }

    public void setResDateIni(Date resDateIni) {
        this.resDateIni = resDateIni;
    }

    public Date getResDateFin() {
        return resDateFin;
    }

    public void setResDateFin(Date resDateFin) {
        this.resDateFin = resDateFin;
    }

    public Customer getResCustomer() {
        return resCustomer;
    }

    public void setResCustomer(Customer resCustomer) {
        this.resCustomer = resCustomer;
    }

    public Vehicle getResVehicle() {
        return resVehicle;
    }

    public void setResVehicle(Vehicle resVehicle) {
        this.resVehicle = resVehicle;
    }
    
}
