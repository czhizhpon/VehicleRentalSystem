/**
 * @(#)BillHead.java	0.0.1, 16-Jun-2019 
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
    private double heaDisc;
    private double heaTotal;
    private Date heaDate;
    private char heaStatus;
    private Customer customer;
    private List<BillDetail> heaDetails;

    public BillHead() {
    }
    
    public BillHead(int heaId, double heaSubtotal, double heaVat, double heaDisc, 
            double heaTotal, Date heaDate, char heaStatus, Customer customer) {
        this.heaId = heaId;
        this.heaSubtotal = heaSubtotal;
        this.heaVat = heaVat;
        this.heaDisc = heaDisc;
        this.heaTotal = heaTotal;
        this.heaDate = heaDate;
        this.heaStatus = heaStatus;
        this.customer = customer;
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

    public double getHeaDisc() {
        return heaDisc;
    }

    public void setHeaDisc(double heaDisc) {
        this.heaDisc = heaDisc;
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

    public char getHeaStatus() {
        return heaStatus;
    }

    public void setHeaStatus(char heaStatus) {
        this.heaStatus = heaStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BillDetail> getHeaDetails() {
        return heaDetails;
    }

    public void setHeaDetails(List<BillDetail> heaDetails) {
        this.heaDetails = heaDetails;
    }
    
    public boolean createBillDetail(BillDetail billDetail){
        if (this.heaDetails == null)
            this.heaDetails = new ArrayList<>();
        this.heaDetails.add(billDetail);
        return true;
    }
    
    public BillDetail readDetail(int renIndex){
        if (this.heaDetails == null) 
            throw new NullPointerException();
        return this.heaDetails.get(renIndex);
    }
    
    public boolean updateDetail(int renIndex, BillDetail billDetail){
        if (this.heaDetails == null) 
            throw new NullPointerException();
        this.heaDetails.set(renIndex, billDetail);
        return true;
    }
    
    public boolean deleteDetail (int renIndex){
        if (this.heaDetails == null) 
            throw new NullPointerException();
        this.heaDetails.remove(renIndex);
        return true;
    }

    @Override
    public String toString() {
        return "BillHead{" + "heaId=" + heaId + ", heaSubtotal=" + heaSubtotal 
                + ", heaVat=" + heaVat + ", heaDisc=" + heaDisc + ", heaTotal=" 
                + heaTotal + ", heaDate=" + heaDate + ", heaStatus=" + heaStatus 
                + ", customer=" + customer + ", heaDetails=" + heaDetails + '}';
    }
    
    
    
}
