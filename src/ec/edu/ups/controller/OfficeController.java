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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 12-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class OfficeController {
    
    //private Office conOffice;
    
    private CityController offCity;
    private ProvinceController offProvince;
    
    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rstat;
    private Statement stat;

    public OfficeController() {
    }

//    public Office getConOffice() {
//        return conOffice;
//    }
//
//    public void setConOffice(Office conOffice) {
//        this.conOffice = conOffice;
//    }
    
    public boolean createOffice(int offId, String offMainSt, String offSideSt, 
            String offNumber, String offCodPostal){
        Office conOffice = new Office(offId, offMainSt, offSideSt, offNumber, 
                offCodPostal);
        return true;
    }
    
    public boolean setCity(Office conOffice, int citId, String citName){
        City city = new City(citId, citName);
        conOffice.setOffCity(city);
        return true;
    }
    
    public boolean setProvince(Office conOffice, int proId, String proName){
        Province province = new Province(proId, proName);
        conOffice.getOffCity().setCitProvince(province);
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
    
    public Office loadOffice(int proId, int citId, int offId){
        conn = new SQLConection().conectarMySQL();
        
        String query;
        
        try {
            
            query = "SELECT p.pro_id, p.pro_name, c.cit_id, c.cit_name, o.off_id, \n" 
                    + "o.off_main_st, o.off_side_st, o.off_number, o.off_cod_postal\n" 
                    + "FROM vrs_provinces p, vrs_cities c, vrs_offices o \n" 
                    + "WHERE p.pro_id = " + proId + " AND c.cit_id = " + citId + "\n"
                    + "AND o.off_id = " + offId + " ;";
            runLoadStatement(query);
            
            while(rstat.next()){
                
                Province province = new Province(rstat.getInt(1), rstat.getString(2));
                City city = new City(rstat.getInt(3), rstat.getString(4));
                Office office = new Office(rstat.getInt(5), rstat.getString(6), 
                        rstat.getString(7), rstat.getString(8), rstat.getString(9));
                
                
                Office conOffice = new Office(office.getOffId(), office.getOffMainSt(), office.getOffSideSt(), 
                        office.getOffNumber(), office.getOffCodPostal());
                
                setCity(conOffice, city.getCitId(), city.getCitName());
                
                setProvince(conOffice, province.getProId(), province.getProName());
                
                return conOffice;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
        return null;
    }
    
    public List<Province> getProvinces(){
        List<Province> provinces =  new ArrayList<>();
        conn = new SQLConection().conectarMySQL();
        
        String query = "SELECT *\n" +
                        "FROM vrs_provinces;";
        
        runLoadStatement(query);
        try {
            while(rstat.next()){
                Province province = new Province(rstat.getInt(1), 
                        rstat.getString(2));
                provinces.add(province);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return provinces;
    }
    
    public List<City> getCities(int proId){
        List<City> cities = new ArrayList<>();
        conn = new SQLConection().conectarMySQL();
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id = " + proId + ";";
        runLoadStatement(query);
        try {
            while (rstat.next()) {                
                City city = new City(rstat.getInt(1), rstat.getString(2));
                cities.add(city);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return cities;
    }
    
    public List<Office> getOffices(int citId){
        List<Office> offices = new ArrayList<>();
        conn = new SQLConection().conectarMySQL();
        String query = "SELECT o.off_id, o.off_main_st, o.off_side_st, "
                + "o.off_number, o.off_cod_postal\n" 
                +"FROM vrs_offices o\n" 
                + "WHERE o.cit_id = " + citId + ";";
        runLoadStatement(query);
        try {
            while (rstat.next()) {                
                Office office = new Office(rstat.getInt(1), rstat.getString(2), 
                        rstat.getString(3), rstat.getString(4), rstat.getString(5));
                offices.add(office);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return offices;
        
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
        return "OfficeController{" + "conOffices=" + /*conOffice*/ + '}';
    }

    
    
}
