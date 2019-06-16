/**
 * @(#)UserController.java	0.0.1, 12-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.model.City;
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
    
    private List<Province> conProvinces;

    public OfficeController() {
    }

    public OfficeController(List<Province> conProvinces) {
        this.conProvinces = conProvinces;
    }
    
    public List<Province> getConProvinces() {
        return conProvinces;
    }

    public void setConProvinces(List<Province> conProvinces) {
        this.conProvinces = conProvinces;
    }
    
    public boolean createProvince(int proId, String proName){
        if (this.conProvinces == null)
            this.conProvinces = new ArrayList<>();
        Province province = new Province(proId, proName);
        this.conProvinces.add(province);
        return true;
    }
    
    public boolean createCity(int proIndex,int citId, String citName){
        City city = new City(citId, citName);
        this.conProvinces.get(proIndex).createCity(city);
        return true;
    }
    
    public boolean createOffice(int proIndex, int citIndex, int offId, 
            String offMainSt, String offSideSt, int offNumber, 
            String offCodPostal){
        Office office = new Office(offId, offMainSt, offSideSt, offNumber, 
                offCodPostal);
        this.conProvinces.get(proIndex).getProCities().get(citIndex)
                .createOffice(office);
        return true;
    }

    @Override
    public String toString() {
        return "OfficeController{" + "conProvinces=" + conProvinces.toString() + '}';
    }
    
    
}
