/**
 * @(#)City.java	0.0.1, 16-Jun-2019 
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
public class City {
    
    private int citId;
    private String citName;
    private Province citProvince;

    public City(int citId, String citName) {
        this.citId = citId;
        this.citName = citName;
    }

    public int getCitId() {
        return citId;
    }

    public void setCitId(int citId) {
        this.citId = citId;
    }

    public String getCitName() {
        return citName;
    }

    public void setCitName(String citName) {
        this.citName = citName;
    }

    public Province getCitProvince() {
        return citProvince;
    }

    public void setCitProvince(Province citProvince) {
        this.citProvince = citProvince;
    }

    @Override
    public String toString() {
        return "City{" + "citId=" + citId + ", citName=" + citName 
                + ", citProvince=" + citProvince + '}';
    }
    
    
    
    
}
