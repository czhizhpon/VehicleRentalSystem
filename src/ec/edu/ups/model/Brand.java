/**
 * @(#)Brand.java	0.0.1, 11-Jun-2019 
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
public class Brand {
    
    private int braId;
    private String braName;
    private List<Model> braModels;

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

    public List<Model> getBraModels() {
        return braModels;
    }

    public void setBraModels(List<Model> braModels) {
        this.braModels = braModels;
    }

    public boolean createModel(Model model){
        if (this.braModels == null)
            this.braModels = new ArrayList<>();
        this.braModels.add(model);
        return true;
    }
    
    public Model readModel(int braId){
        if (this.braModels == null)
            throw new NullPointerException();
        return this.braModels.get(braId);
    }
    
    public boolean updateModel(int braId, Model model){
        if (this.braModels == null)
            throw new NullPointerException();
        this.braModels.set(braId, model);
        return true;
    }
    
    public boolean deleteModel(int braId){
        if (this.braModels == null)
            throw new NullPointerException();
        this.braModels.remove(braId);
        return true;
    }
    
    @Override
    public String toString() {
        return "Brand{" + "braId=" + braId + ", braName=" + braName 
                + ", braModels=" + braModels + '}';
    }
    
}
