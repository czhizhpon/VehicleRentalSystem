/**
 * @(#)Model.java	0.0.1, 11-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class Model {
    
    private int modId;
    private String modName;
    private List<Vehicle> modVehicles;

    public Model(int modId, String modName) {
        this.modId = modId;
        this.modName = modName;
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

    public List<Vehicle> getModVehicles() {
        return modVehicles;
    }

    public void setModVehicles(List<Vehicle> modVehicles) {
        this.modVehicles = modVehicles;
    }

    public boolean createVehicle(Vehicle vehicle){
        if (this.modVehicles == null)
            this.modVehicles = new ArrayList<>();
        this.modVehicles.add(vehicle);
        return true;
    }
    
    public Vehicle readVehicle(int vehIndex){
        if(this.modVehicles == null)
            throw new NullPointerException();
        return this.modVehicles.get(vehIndex);
    }
    
    public boolean updateVehicle(int vehIndex, Vehicle vehicle){
        if(this.modVehicles == null)
            throw new NullPointerException();
        this.modVehicles.set(vehIndex, vehicle);
        return true;
    }
    
    public boolean deleteVehicle(int vehIndex){
        if(this.modVehicles == null)
            throw new NullPointerException();
        this.modVehicles.remove(vehIndex);
        return true;
    }

    @Override
    public String toString() {
        return "Model{" + "modId=" + modId + ", modName=" + modName 
                + ", modVehicles=" + modVehicles.toString() + '}';
    }
    
    
}
