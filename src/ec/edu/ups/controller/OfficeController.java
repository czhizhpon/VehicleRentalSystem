/**
 * @(#)UserController.java	0.0.1, 12-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.model.Office;
import ec.edu.ups.model.Province;
import ec.edu.ups.model.User;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

/**
 * @since 12-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class OfficeController {
    
    private VehicleRentalSystem vrs;

    public OfficeController(VehicleRentalSystem vrs) {
        this.vrs = vrs;
    }

    public VehicleRentalSystem getVrs() {
        return vrs;
    }

    public void setVrs(VehicleRentalSystem vrs) {
        this.vrs = vrs;
    }
    
    public boolean createOffice(int provinceIndex, int cityIndex,int offId, 
            String offMainSt, String offSideSt, int offNumber, String offCodPostal){
        
        Office office = new Office(offId, offMainSt, offSideSt, offNumber, 
                offCodPostal);
        this.vrs.getVrsProvinces().get(provinceIndex).getProCities().
                get(cityIndex).createOffice(office);
        return true;
    }
    
}
