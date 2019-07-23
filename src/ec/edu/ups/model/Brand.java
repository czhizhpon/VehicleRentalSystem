/**
 * @(#)Brand.java	0.0.1, 16-Jun-2019 
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
public class Brand {
    
    private int braId;
    private String braName;

    public Brand() {
    }

    public Brand(int braId, String braName) {
        this.braId = braId;
        this.braName = braName;
    }

    public int getBraId() {
        return braId;
    }

    public void setBraId(int braId) {
        this.braId = braId;
    }

    public String getBraName() {
        return braName;
    }

    public void setBraName(String braName) {
        this.braName = braName;
    }
    
    @Override
    public String toString() {
        return "Brand{" + "braId=" + braId + ", braName=" + braName + '}';
    }
    
}
