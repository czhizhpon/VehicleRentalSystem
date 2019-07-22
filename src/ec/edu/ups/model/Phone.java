/**
 * @(#)Phone.java	0.0.1, 11-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class Phone {
    
    private int phoId;
    private String phoNumber;
    private String phoType;

    public Phone(int phoId, String phoNumber, String phoType) {
        this.phoId = phoId;
        this.phoNumber = phoNumber;
        this.phoType = phoType;
    }

    public int getPhoId() {
        return phoId;
    }

    public void setPhoId(int phoId) {
        this.phoId = phoId;
    }

    public String getPhoNumber() {
        return phoNumber;
    }

    public void setPhoNumber(String phoNumber) {
        this.phoNumber = phoNumber;
    }

    public String getPhoType() {
        return phoType;
    }

    public void setPhoType(String phoType) {
        this.phoType = phoType;
    }

    @Override
    public String toString() {
        return "Phone{" + "phoId=" + phoId + ", phoNumber=" + phoNumber + 
                ", phoType=" + phoType + '}';
    }
    
}
