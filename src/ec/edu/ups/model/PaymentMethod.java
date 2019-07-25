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
public class PaymentMethod {
    
    private int payId;
    private String payType;
    private int payDiscountPct;

    public PaymentMethod() {
    }

    public PaymentMethod(int payId, String payType, int payDiscountPct) {
        this.payId = payId;
        this.payType = payType;
        this.payDiscountPct = payDiscountPct;
    }
    
    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getPayDiscountPct() {
        return payDiscountPct;
    }

    public void setPayDiscountPct(int payDiscountPct) {
        this.payDiscountPct = payDiscountPct;
    }
    
    
    
}
