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
    private Date resDate;
    private Customer resCustomer;
    private Vehicle resVehicle;

    public Reservation() {
    }

    public Reservation(int resId, Date resDate, Customer resCustomer,Vehicle resVehicle) {
        this.resId = resId;
        this.resDate = resDate;
        this.resCustomer = resCustomer;
        this.resVehicle = resVehicle;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
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

    @Override
    public String toString() {
        return "Reservation{" + "resId=" + resId + ", resDate=" + resDate 
                + ", resVehicle=" + resVehicle.toString() + '}';
    }
    
    
}
