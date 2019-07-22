/**
 * @(#)Model.java	0.0.1, 16-Jun-2019 
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
public class Model {
    
    private int modId;
    private String modName;
    private double modCost;
    private Brand modBrand;

    public Model(int modId, String modName, Brand modBrand) {
        this.modId = modId;
        this.modName = modName;
        this.modBrand = modBrand;
    }
    
    public int getModId() {
        return modId;
    }

    public void setModId(int modId) {
        this.modId = modId;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public double getModCost() {
        return modCost;
    }

    public void setModCost(double modCost) {
        this.modCost = modCost;
    }

    public Brand getModBrand() {
        return modBrand;
    }

    public void setModBrand(Brand modBrand) {
        this.modBrand = modBrand;
    }

    @Override
    public String toString() {
        return "Model{" + "modId=" + modId + ", modName=" + modName 
                + ", modBrand=" + modBrand + '}';
    }
    
}
