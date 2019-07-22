/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.model;

/**
 *
 * @author edd
 */
public class BillDetail {
    private int detId;
    private int detDuration;
    private double detDayCost;
    private double detExtraDamage;
    private double detExtraDelay;
    private double detSubtotal;
    private Rental detRental;

    public int getDetId() {
        return detId;
    }

    public void setDetId(int detId) {
        this.detId = detId;
    }

    public int getDetDuration() {
        return detDuration;
    }

    public void setDetDuration(int detDuration) {
        this.detDuration = detDuration;
    }

    public double getDetDayCost() {
        return detDayCost;
    }

    public void setDetDayCost(double detDayCost) {
        this.detDayCost = detDayCost;
    }

    public double getDetExtraDamage() {
        return detExtraDamage;
    }

    public void setDetExtraDamage(double detExtraDamage) {
        this.detExtraDamage = detExtraDamage;
    }

    public double getDetExtraDelay() {
        return detExtraDelay;
    }

    public void setDetExtraDelay(double detExtraDelay) {
        this.detExtraDelay = detExtraDelay;
    }

    public double getDetSubtotal() {
        return detSubtotal;
    }

    public void setDetSubtotal(double detSubtotal) {
        this.detSubtotal = detSubtotal;
    }

    public Rental getDetRental() {
        return detRental;
    }

    public void setDetRental(Rental detRental) {
        this.detRental = detRental;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "detId=" + detId + ", detDuration=" + detDuration 
                + ", detDayCost=" + detDayCost + ", detExtraDamage=" 
                + detExtraDamage + ", detExtraDelay=" + detExtraDelay 
                + ", detSubtotal=" + detSubtotal + ", detRental=" + detRental + '}';
    }
    
    
    
}
