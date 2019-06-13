/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controller;

import ec.edu.ups.model.Brand;
import ec.edu.ups.model.City;
import ec.edu.ups.model.Privilege;
import ec.edu.ups.model.Province;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edd
 */
public class VehicleRentalSystem {
    
    private List<Province> vrsProvinces;
    private List<Privilege> vrsPrivileges;
    private List<Brand> vrsBrands;

    public List<Province> getVrsProvinces() {
        return vrsProvinces;
    }

    public void setVrsProvinces(List<Province> vrsProvinces) {
        this.vrsProvinces = vrsProvinces;
    }

    public List<Privilege> getVrsPrivileges() {
        return vrsPrivileges;
    }

    public void setVrsPrivileges(List<Privilege> vrsPrivileges) {
        this.vrsPrivileges = vrsPrivileges;
    }

    public List<Brand> getVrsBrands() {
        return vrsBrands;
    }

    public void setVrsBrands(List<Brand> vrsBrands) {
        this.vrsBrands = vrsBrands;
    }

    public boolean createProvince(int proId, String proName){
        if(this.vrsProvinces == null)
            this.vrsProvinces = new ArrayList<>();
        Province province = new Province(proId, proName);
        this.vrsProvinces.add(province);
        return true;
    }
    
    public boolean createCity(int provinceIndex,int citId, String citName){
        City city = new City(citId, citName);
        this.vrsProvinces.get(provinceIndex).createCity(city);
        return true;
    }
    
    @Override
    public String toString() {
        return "VehicleRentalSystem{" + "vrsProvinces=" + vrsProvinces.toString() 
                + ", vrsPrivileges=" + vrsPrivileges.toString() + ", vrsBrands=" 
                + vrsBrands.toString() + '}';
    }

    
    
    
}
