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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 12-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class OfficeController {
    
    private List<Province> conProvinces;
    
    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rstat;
    private Statement stat;

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
    
    
    public void insertProvince(Province province){
        conn = new SQLConection().conectarMySQL();
        String query = "INSERT INTO vrs_provinces VALUES("
                + province.getProId() + ","
                + "'" + province.getProName() + "'"
                + ");";
        runInsertStatement(query);
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertCity(Province province, City city){
        conn = new SQLConection().conectarMySQL();
        String query = "INSERT INTO vrs_cities VALUES("
                + city.getCitId() + ","
                + city.getCitName() + ","
                + province.getProId()
                + ");";
        runInsertStatement(query);
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertOffice(City city, Office office){
        conn = new SQLConection().conectarMySQL();
        String query = "INSERT INTO vrs_offices VALUES("
                + office.getOffId() + ","
                + office.getOffMainSt() + ","
                + office.getOffSideSt() + ","
                + office.getOffNumber() + ","
                + office.getOffCodPostal() + ","
                + city.getCitId()
                + ");";
        runInsertStatement(query);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void loadOffices(){
        conn = new SQLConection().conectarMySQL();
        int proIndex = 0;
        int citIndex = 0;
        
        String query;
        
        try {
            
            query = "SELECT pro_id, pro_name "
                    + "FROM vrs_provinces;";
            runLoadStatement(query);
            while(rstat.next()){
                
                createProvince(rstat.getInt(1), rstat.getString(2));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean runInsertStatement(String query){
        try {
            pstat = conn.prepareStatement(query);
            pstat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
        return true;
    }
    
    public void runLoadStatement(String query){
        try {
            stat = conn.createStatement();
            rstat = stat.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    @Override
    public String toString() {
        return "OfficeController{" + "conProvinces=" + conProvinces + '}';
    }
    
    
}
